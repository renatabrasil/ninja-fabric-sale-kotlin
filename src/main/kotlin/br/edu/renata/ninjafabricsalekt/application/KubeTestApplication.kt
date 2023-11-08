package br.edu.renata.ninjafabricsalekt.application

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.reflect.KClass


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

    @Before("@annotation(ContextValidator)")
    fun validate(joinPoint: JoinPoint) {
        val validator = (joinPoint.target.javaClass.getMethod(joinPoint.signature.name)
            .run { this.getAnnotation(ContextValidator::class.java) }).validator.java.getDeclaredConstructor().newInstance()

        val executor = (validator as AccountValidator).validate()


        print("sdsd")
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
