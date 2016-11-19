/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.daelly.project.onlinejudge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OnlineJudgeApplication{

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(OnlineJudgeApplication.class, args);
//		System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Map<String,SpringTemplateEngine> beans = ctx.getBeansOfType(SpringTemplateEngine.class);
//        System.out.println(beans.isEmpty());
//        Set<Entry<String, SpringTemplateEngine>> entrySet = beans.entrySet();
//        for (Entry<String, SpringTemplateEngine> entry : entrySet) {
//        	SpringTemplateEngine engine = entry.getValue();
//			System.out.println(entry.getKey()+"------------"+engine.getClass());
//			Set<IDialect> dialects = engine.getDialects();
//			System.out.println(dialects);
//		}
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
	}

}
