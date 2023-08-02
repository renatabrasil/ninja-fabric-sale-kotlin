package br.edu.renata.ninjafabricsalekt.application.utils

import br.edu.renata.ninjafabricsalekt.application.models.Color
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class ColorConverter : AttributeConverter<Color, String> {
    override fun convertToDatabaseColumn(attribute: Color?): String? {
        return attribute?.name
    }

    override fun convertToEntityAttribute(dbData: String?): Color? {
        return dbData?.let {
            Color.valueOf(dbData)
        }
    }

}