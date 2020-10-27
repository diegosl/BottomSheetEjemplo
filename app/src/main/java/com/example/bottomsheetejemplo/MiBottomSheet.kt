package com.example.bottomsheetejemplo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RatingBar
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MiBottomSheet : BottomSheetDialogFragment() {
    private lateinit var puntuacionGeneralLocalView: RatingBar
    private lateinit var puntuacionTratoLocalView: RatingBar
    private lateinit var puntuacionZonaRepartoLocaView: RatingBar
    private lateinit var evaluacionAbonoExtraLocalSiView: RadioButton
    private lateinit var evaluacionAbonoExtraLocalNoView: RadioButton
    private lateinit var evaluacionComidaLocalSiView: RadioButton
    private lateinit var evaluacionComidaLocalNoView: RadioButton
    private lateinit var evaluacionTareaExtraSiView: RadioButton
    private lateinit var evaluacionTareaExtraNoView: RadioButton
    private lateinit var evaluacionVolverLocalSiView: RadioButton
    private lateinit var evaluacionVolverLocalNoView: RadioButton
    private lateinit var comentarioLocalView: TextInputLayout
    private lateinit var enviarCalificacionLocalView: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_layout, container, false)
        puntuacionGeneralLocalView = view.findViewById(R.id.rb_estrellas)
        puntuacionTratoLocalView = view.findViewById(R.id.rb_trato_local)
        puntuacionZonaRepartoLocaView = view.findViewById(R.id.rb_zona_reparto)
        evaluacionAbonoExtraLocalSiView = view.findViewById(R.id.rb_abono_extra_si)
        evaluacionAbonoExtraLocalNoView = view.findViewById(R.id.rb_abono_extra_no)
        evaluacionComidaLocalSiView = view.findViewById(R.id.rb_ofrecio_comida_si)
        evaluacionComidaLocalNoView = view.findViewById(R.id.rb_ofrecio_comida_no)
        evaluacionTareaExtraSiView = view.findViewById(R.id.rb_tarea_extra_si)
        evaluacionTareaExtraNoView = view.findViewById(R.id.rb_tarea_extra_no)
        evaluacionVolverLocalSiView = view.findViewById(R.id.rb_volver_local_si)
        evaluacionVolverLocalNoView = view.findViewById(R.id.rb_volver_local_no)
        comentarioLocalView = view.findViewById(R.id.comentario_local)
        enviarCalificacionLocalView = view.findViewById(R.id.btn_enviar_calificacion_local)
        chequearPuntajeLocal()
        return view
    }

    fun chequearPuntajeLocal() {
        // Parametros de endpoint /Puntuar
        var puntuacionGeneralLocal: Int? = null
        var puntuacionTratoLocal: Int? = null
        var puntuacionZonaRepartoLocal: Int? = null
        var evaluacionAbonoExtraLocal: Int? = null
        var evaluacionComidaLocal: Int? = null
        var evaluacionTareaExtra: Int? = null
        var evaluacionVolverLocal: Int? = null
        var comentarioLocal: String

        puntuacionGeneralLocalView.setOnRatingBarChangeListener { _, rating, _ ->
            puntuacionGeneralLocal = rating.toInt()
        }
        puntuacionTratoLocalView.setOnRatingBarChangeListener { _, rating, _ ->
            puntuacionTratoLocal = rating.toInt()
        }
        puntuacionZonaRepartoLocaView.setOnRatingBarChangeListener { _, rating, _ ->
            puntuacionZonaRepartoLocal = rating.toInt()
        }
        enviarCalificacionLocalView.setOnClickListener {
            comentarioLocal = comentarioLocalView.editText?.text.toString()
            evaluacionAbonoExtraLocal = chequearRadioButton(evaluacionAbonoExtraLocalSiView, evaluacionAbonoExtraLocalNoView)
            evaluacionComidaLocal = chequearRadioButton(evaluacionComidaLocalSiView, evaluacionComidaLocalNoView)
            evaluacionTareaExtra = chequearRadioButton(evaluacionTareaExtraSiView, evaluacionTareaExtraNoView)
            evaluacionVolverLocal = chequearRadioButton(evaluacionVolverLocalSiView, evaluacionVolverLocalNoView)
            //Snackbar.make(enviarCalificacionLocalView, "Calificación enviada", Snackbar.LENGTH_LONG).show()
            Log.d("CALIFICACION", "Comentario: $comentarioLocal Puntuacion General: $puntuacionGeneralLocal Puntuacion Trato: $puntuacionTratoLocal Puntuacion Zona Reparto: $puntuacionZonaRepartoLocal " +
                    "Evalucion Abono Extra: $evaluacionAbonoExtraLocal Evaluacion Comida: $evaluacionComidaLocal Evaluacion Tarea Extra: $evaluacionTareaExtra " +
                    "Evaluacion Volver Local: $evaluacionVolverLocal")
            this.dismiss()
        }
    }

    fun chequearRadioButton(radioButtonSi: RadioButton, radioButtonNo: RadioButton): Int? {
        var estado: Int? = 0
        if(radioButtonSi.isChecked || radioButtonNo.isChecked) {
            if(radioButtonSi.isChecked) {
                estado = 1
            }
            if(radioButtonNo.isChecked) {
                estado = 2
            }
        }
        else {
            estado = null
        }

        return estado
    }

    /*fun chequearEmoji(emojiMal: ImageView, emojiIntermedio: ImageView, emojiBien: ImageView): Int? {
        var estado: Int? = 0
        if(radioButtonSi.isChecked || radioButtonNo.isChecked) {
            if(radioButtonSi.isChecked) {
                estado = 1
            }
            if(radioButtonNo.isChecked) {
                estado = 2
            }
        }
        else {
            estado = null
        }

        return estado
    }*/
}