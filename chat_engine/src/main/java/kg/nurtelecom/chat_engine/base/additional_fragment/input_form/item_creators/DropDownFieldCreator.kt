package kg.nurtelecom.chat_engine.base.additional_fragment.input_form.item_creators

import android.content.Context
import android.widget.LinearLayout
import kg.nurtelecom.design.chili2.view.modals.bottom_sheet.serach_bottom_sheet.Option
import kg.nurtelecom.chat_engine.custom_views.DropDownInputField
import kg.nurtelecom.chat_engine.model.DropDownFieldInfo

object DropDownFieldCreator : ValidatableItem() {

    fun create(
        context: Context,
        dropDownFieldInfo: DropDownFieldInfo,
        onSelectionChanged: (selected: List<String>, isValid: Boolean) -> Unit
    ): DropDownInputField {
        return DropDownInputField(context).apply {
            tag = dropDownFieldInfo.fieldId
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(
                    resources.getDimensionPixelSize(kg.nurtelecom.design.chili2.R.dimen.padding_16dp),
                    resources.getDimensionPixelSize(kg.nurtelecom.design.chili2.R.dimen.padding_8dp),
                    resources.getDimensionPixelSize(kg.nurtelecom.design.chili2.R.dimen.padding_16dp),
                    resources.getDimensionPixelSize(kg.nurtelecom.design.chili2.R.dimen.padding_8dp)
                )
            }
            setCornerRadius(resources.getDimension(kg.nurtelecom.design.chili2.R.dimen.radius_12dp))
            setupViews(dropDownFieldInfo, onSelectionChanged)
            dropDownFieldInfo.options?.let {
                options = it.map { Option(it.id, it.label ?: "", it.isSelected ?: false) }
            }
            setHint(dropDownFieldInfo.label ?: "")
        }
    }

}