package org.faccat.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import android.util.TypedValue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numeros
        btn1.setOnClickListener  {appendOnExpresstion("1",true)}
        btn2.setOnClickListener {appendOnExpresstion("2", true)}
        btn3.setOnClickListener {appendOnExpresstion("3",true)}
        btn4.setOnClickListener {appendOnExpresstion("4", true)}
        btn5.setOnClickListener {appendOnExpresstion("5",true)}
        btn6.setOnClickListener {appendOnExpresstion("6", true)}
        btn7.setOnClickListener {appendOnExpresstion("7",true)}
        btn8.setOnClickListener {appendOnExpresstion("8", true)}
        btn9.setOnClickListener {appendOnExpresstion("9",true)}
        btn0.setOnClickListener {appendOnExpresstion("0",true)}
        btnPonto.setOnClickListener {appendOnExpresstion(".",true)}
        //Operação
        btnMais.setOnClickListener {appendOnExpresstion("+",false)}
        btnMenos.setOnClickListener {appendOnExpresstion("-", false)}
        btnMultiplicacao.setOnClickListener {appendOnExpresstion("*",false)}
        btnDivisao.setOnClickListener {appendOnExpresstion("/", false)}
        btnResultado.setOnClickListener {appendOnExpresstion("=", false)}

        btnApaga.setOnClickListener {
            tvExpression.text =""
            tvResult.text = ""
        }

        btnVolta.setOnClickListener{
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0, string.length-1)
            }
            tvResult.text =""
        }

        btnResultado.setOnClickListener{
            val str = tvExpression.text
            tvExpression.text =""

            try{
                if("+" in str){
                    imprimeResultado(soma(str))
                }
                else if("-" in str) {
                    imprimeResultado(subtracao(str))
                }
                else if("/" in str) {
                    imprimeResultado(divisao(str))
                }
                else if("*" in str){
                    imprimeResultado(multiplicacao(str))

                }
            }
            catch(e: Exception){
                tvExpression.text = ""
            }

        }
    }

    fun appendOnExpresstion(string: String, canClear: Boolean)   {
        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            try{
                if("+" in tvExpression.text){
                    imprimeResultado(soma(tvExpression.text))
                    tvExpression.text =""
                    tvExpression.text = tvResult.text
                    tvResult.text =""
                    tvExpression.append(string)

                }
                else if("-" in tvExpression.text) {
                    imprimeResultado(subtracao(tvExpression.text))
                    tvExpression.text =""
                    tvExpression.text = tvResult.text
                    tvResult.text =""
                    tvExpression.append(string)
                }
                else if("/" in tvExpression.text) {
                    imprimeResultado(divisao(tvExpression.text))
                    tvExpression.text =""
                    tvExpression.text = tvResult.text
                    tvResult.text =""
                    tvExpression.append(string)
                }
                else if("*" in tvExpression.text){
                    imprimeResultado(multiplicacao(tvExpression.text))
                    tvExpression.text =""
                    tvExpression.text = tvResult.text
                    tvResult.text =""
                    tvExpression.append(string)
                }
                else {
                    tvExpression.append(tvResult.text)
                    tvExpression.append(string)
                    tvResult.text = ""
                }
            }
            catch(e : Exception){
                tvExpression.text =""
            }



            /*

            */

        }

    }
    private fun imprimeResultado(result : String){
        tvResult.text = result
    }
    private fun soma(str : CharSequence) : String{
        val separate2 = str.split("+")
        var resultado : Double = 0.0
        for (i in separate2.indices) {
            resultado  += ((separate2[i]).toDouble())
        }

        return resultado.toString()

    }
    private fun multiplicacao(str : CharSequence): String{

        var resultado : Double = 1.0
        val separate2 = str.split("*")
        for (i in separate2.indices) {
            resultado *= ((separate2[i]).toDouble())
        }
        return resultado.toString()
    }

    private fun divisao(str : CharSequence) : String{
        val separate2 = str.split("/")
        var resultado : Double = 0.0
        var a : Double
        for (i in separate2.indices) {
            a = ((separate2[0]).toDouble())
            resultado = (a /(separate2[i]).toDouble())
        }
        return resultado.toString()
    }
    private fun subtracao(str : CharSequence): String {
        val separate2 = str.split("-")
        var resultado : Double
        resultado = 0.0
        var a : Double
        for (i in separate2.indices) {
            a = ((separate2[0]).toDouble())
            resultado  = (a - (separate2[i]).toDouble())
        }
        return resultado.toString()
    }



}

