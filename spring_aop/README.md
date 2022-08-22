# SpringAOP

## Demo速览：

### 1. cglib、jdk动态代理

- cglib : cn/ixinjiu/spring_aop/proxy/cglib


其中Advice为切面类，Target为目标类，在ProxyTest进行织入

- jdk : cn/ixinjiu/spring_aop/proxy/jdk


同上

### 2. Spring配置类声明切面

- 其中MyAspect为切面类，Target为目标类

- 在applicationContext.xml中声明切面类，目标类，配置aop进行织入

- 在src/test/java/cn/ixinjiu/test/AopTest.java进行测试


### 3. Spring注解声明切面

同上