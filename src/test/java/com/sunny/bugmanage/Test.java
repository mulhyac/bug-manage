package com.sunny.bugmanage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * @author sunny
 * @className com.sunny.bugmanage.Test
 * @date 2017-06-17 13:27
 * @description:
 */
public class Test
{
	public static void main(String[] args) {
		String js="{\"error_response\":{\"code\":\"40002\",\"msg\":\"Invalid Arguments\",\"sub_code\":\"isv.code-invalid\",\"sub_msg\":\"授权码code无效\"},\"sign\":\"TZtoanjiojKvHKOeVllXoFfX6MlT2JKpEKUchz0sBUoFYZ34NwclM4voZg4zVf7CgpVfYFe82moHXWr4G9VzwBROb8IC/j+Erl/FNlEdIxN9uKaCj2cc1Tj1uCYg2R/UEf+auoiRHsHZT28gf6JjuDXEiDVS3+3XbV2BkoG0rW8Ss/jl1Wd7Hem/9Im0HKOsAzdqjvb5DkNxyRso5Q91oRjxaOuvfEEdLS6etB9G3Uqz0yTmdiZlyT/u8fllTUaH6nyC7/lNQA6oQa/RHyvRN46wm6G8V2NzdEhflRdgYFe1O+SqbVMosCxhqQFguLaP4bJ3afP2zRdvnpCbv9u0ig==\"}";
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject object=gson.fromJson(js,JsonObject.class);
		String code=object.getAsJsonObject("error_response").getAsJsonPrimitive("code").getAsString();
		System.out.println(code);
	}
}
