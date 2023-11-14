package br.edu.renata.ninjafabricsalekt.application

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
    @ContextValidator(validator = CustomerValidator::class)
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

        try {
            with(contextValidator.validator) {
                // Pegar a lista de parametros do validador
                val parameters = this.memberProperties.map {
                    context?.getBean(it.name)
                }
                // *parameters converte em varargs
                this.primaryConstructor!!.call(*parameters.toTypedArray())
            }.validate().also { println("Deu certo") }

        } catch (e: Exception) {
            throw e
        }

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
