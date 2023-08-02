package br.edu.renata.ninjafabricsalekt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class NinjaFabricSaleKtApplication


fun main(args: Array<String>) {
	runApplication<NinjaFabricSaleKtApplication>(*args)
}
