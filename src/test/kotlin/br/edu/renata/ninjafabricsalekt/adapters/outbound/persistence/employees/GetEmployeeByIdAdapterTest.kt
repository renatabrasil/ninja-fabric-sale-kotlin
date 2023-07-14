package br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.employees

import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.entities.EmployeeEntity
import br.edu.renata.ninjafabricsalekt.adapters.outbound.persistence.repositories.EmployeeRepository
import org.jeasy.random.EasyRandom
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito.*
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.NoSuchElementException

class GetEmployeeByIdAdapterTest {
    private val employeeRepository: EmployeeRepository = mock(EmployeeRepository::class.java)

    private val getEmployeeByIdAdapter = GetEmployeeByIdAdapter(employeeRepository)

    @Test
    fun `Verify getEmployeeById successfully`() {
        // Given
        val id = UUID.randomUUID().toString()
        val expectedResult = EasyRandom().objects(EmployeeEntity::class.java, 1).findFirst()

        `when`(employeeRepository.findById(eq(id))).thenReturn(expectedResult)

        // When
        val response = getEmployeeByIdAdapter.findById(id)

        // Then
        assertEquals(expectedResult.get(), response.toEntity())
        verify(employeeRepository, atLeastOnce()).findById(any())

    }

    @Test
    fun `Verify getEmployeeById when not found employee`() {
        // Given
        val id = UUID.randomUUID().toString()

        `when`(employeeRepository.findById(eq(id))).thenReturn(Optional.empty())

        // When
        assertThrows<NoSuchElementException>{ getEmployeeByIdAdapter.findById(id) }

        // Then
        verify(employeeRepository, atLeastOnce()).findById(any())

    }
}