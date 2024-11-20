package br.edu.renata.ninjafabricsalekt.application.services.employees

import br.edu.renata.ninjafabricsalekt.application.models.Employee
import br.edu.renata.ninjafabricsalekt.application.repositories.EmployeeRepository
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito.*
import java.util.*

class GetEmployeeByIdServicesTest {
    private val employeeRepository: EmployeeRepository = mock(EmployeeRepository::class.java)

    private val getEmployeeByIdService = GetEmployeeByIdService(employeeRepository)

    @Test
    fun `Verify getEmployeeById successfully`() {
        // Given
        val id = UUID.randomUUID().toString()
        val expectedResult = EasyRandom().objects(Employee::class.java, 1).findFirst()

        `when`(employeeRepository.findById(eq(id))).thenReturn(expectedResult)

        // When
        val response = getEmployeeByIdService.execute(id)

        // Then
        assertEquals(expectedResult.get(), response)
        verify(employeeRepository, atLeastOnce()).findById(any())

    }

    @Test
    fun `Verify getEmployeeById when not found employee`() {
        // Given
        val id = UUID.randomUUID().toString()

        `when`(employeeRepository.findById(eq(id))).thenReturn(Optional.empty())

        // When
        assertThrows<NoSuchElementException> { getEmployeeByIdService.execute(id) }

        // Then
        verify(employeeRepository, atLeastOnce()).findById(any())

    }
}