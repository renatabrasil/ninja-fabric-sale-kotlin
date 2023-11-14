package br.edu.renata.ninjafabricsalekt.application

import br.edu.renata.ninjafabricsalekt.application.services.employees.GetEmployeeByIdService
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor


@SpringBootApplication
class KubeTestApplication

fun main(args: Array<String>) {
    runApplication<KubeTestApplication>(*args)
}


@RestController
class HelloWorldController {

    @GetMapping("/hello")
//    @TestMe(roles = ["ppp","qqq"])
    @ContextValidator
    fun helloWorld(): String {
        return "Hello World from Kube Kotlin ${Date()}()"
    }

}

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class TestMe(val roles: Array<String>)

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ContextValidator(val validator: KClass<out InstanceValidator> = AccountValidator::class)


@Aspect
@Component
class ExampleAspect {

    @Autowired
    private val context: ApplicationContext? = null

    @Before("@annotation(contextValidator)")
    fun validate(contextValidator: ContextValidator) {


        val kClass = contextValidator.validator
        println(kClass.simpleName)
        kClass.memberProperties.forEach { println(it.returnType) }

        val teste = context?.getBean("getEmployeeByIdService") as GetEmployeeByIdService

        // Pegar a lista de parametros do validador
        val parameters = kClass.memberProperties.map { context.getBean(it.name) }

        // *list.toTypedArray converte em varargs
        contextValidator.validator.primaryConstructor!!.call(*parameters.toTypedArray()).validate()
    }

    @Before("@annotation(TestMe)")
    fun before(joinPoint: JoinPoint) {

        val method = joinPoint.target.javaClass.getMethod(joinPoint.signature.name)
        val x = method.getAnnotation(TestMe::class.java)
        x.roles.forEach { println(it) }
        println(" Check for user access ")
        println(" Allowed execution for {} $joinPoint")
    }

}
