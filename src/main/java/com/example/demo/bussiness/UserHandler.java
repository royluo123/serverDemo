package com.example.demo.bussiness;

import com.example.demo.base.RedisHelper;
import com.example.demo.entity.Data;
import com.example.demo.entity.Info;
import org.springframework.util.StringUtils;

public class UserHandler {
    /**
     * @param info  用户的信息
     * @return      处理用户信息的结果
     */
    public Data dealWith(Info info) {
        Data data = new Data();
        String nickname = info.getNickname();

        if (StringUtils.isEmpty(nickname)) {
            return data.setCode(-1).setResult("Nickname can not be blank.");
        }

        RedisHelper helper = RedisHelper.getRedisHelper();
        String cacheInfo = null;
        if(helper != null){
            cacheInfo = helper.getString(nickname);
        }

        boolean isNew = StringUtils.isEmpty(cacheInfo);
        if(isNew){
            String gender = info.getGender();
            int age = info.getAge();
            if (StringUtils.isEmpty(gender)) {
                return new Data().setCode(-2).setResult("Gender can not be blank.");
            }else if (gender.equals("male")) {
                gender = "boy";
            }else if (gender.equals("female")) {
                gender = "girl";
            }else {
                return data.setCode(-2).setResult("Gender is not legal");
            }

            if (age < 0) {
                return data.setCode(-3).setResult("Age can not be less than zero.");
            }

            String result = nickname + "'s age is " + age + " year old, " + "he(she) is a " + gender;
            helper.setString(nickname, result);
            System.out.println("add a new user: " +result);
            return data.setCode(0).setResult(result);
        }else{
            String result = helper.getString(nickname);
            return data.setCode(0).setResult(result);
        }

    }
}
