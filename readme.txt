访问方式
第一种切点
http://localhost:8080/aopController/Curry
第二种切点
http://localhost:8080/aopController/Durant/1

在Aspect中

主要是切点表达式不一样
pointcut
	在aspect中，定义了切点名称及切点表达式。
	切点名称采用函数的表达方式，但并不是函数。
	主要是切点表达式的时候，可以采用，直接匹配方法名称
	@Pointcut("execution(public * com.example.demo.aop.AopController.*(..)))")
    public void BrokerSjkAspect(){

    }
	
	也可以采用Jeecg中的，直接匹配方法名称上的注解
	@Pointcut("@annotation(org.jeecg.common.aspect.annotation.PermissionData)")

 /**
    * @description  在连接点执行之前执行的通知
    */
    @Before("BrokerSjkAspect()")
    public void doBeforeGame(){
        System.out.println("经纪人正在处理球星赛前事务！");
    }
	
BrokerSjkAspect，这个就是pointcut的名字

如果是有注解的话
定义注解
然后在方法上引用注解
最后定义切面（pointcut找到注解引用点，在这个arround等方法中，使用了getAnnotation这个内容。
	PermissionData pd = method.getAnnotation(PermissionData.class);
		String component = pd.pageComponent();

	