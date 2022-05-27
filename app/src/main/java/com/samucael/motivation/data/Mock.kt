package com.samucael.motivation.data

import com.samucael.motivation.infra.MotivationConstants
import kotlin.random.Random


data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val inclusive = MotivationConstants.FILTER.INCLUSIVE
    private val smile = MotivationConstants.FILTER.SMILE
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val mListPhrase = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", smile),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", smile),
        Phrase("Quando está mais escuro, vemos mais estrelas!", smile),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", smile),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", smile),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", smile),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    fun getPhrase(value: Int): String{
        val filtered = mListPhrase.filter { (it.categoryId == value || value == inclusive) }

        val rand = Random.nextInt(filtered.size)

        return filtered[rand].description
        }
    }

