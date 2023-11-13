package br.edu.renata.ninjafabricsalekt.application

import io.mockk.every
import io.mockk.slot
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [KubeTestApplication::class, ExampleAspect::class, ContextValidator::class])
@Import(AnnotationAwareAspectJAutoProxyCreator::class)
class KubeTestApplicationTest {
    private val kubeTest = ExampleAspect()

    @Test
    fun `Testes`() {
        val response = kubeTest.validate(captorAnnotation.captured)

        println("oi")

    }

//    @Test
//    fun `Should test annotation test`(){
//        val annotation = mockk<ContextValidator>()
//        val accountValidator = mockk<AccountValidator>()
//        every { annotation.validator } answers {
//            InstanceValidator::class
//        }
////        every { annotation.validator } returns mock()
////        every { annotation.validator.createInstance() } returns accountValidator
////        mockkObject(annotation)
////        whenever(annotation.validator.createInstance()).thenReturn(mock())
//        val response = kubeTest.validate(annotation)
//
//
//    }
}