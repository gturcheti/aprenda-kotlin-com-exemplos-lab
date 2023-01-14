// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(
        val id: String,
        val nome:  String,
        val cpf:  String,
        val nascimento: String,
)

data class ConteudoEducacional(var nome: String, val duracao: Int, var nivel: Nivel,)

class Formacao(
        val nome: String,
        var cursos: MutableList<ConteudoEducacional>,
        var inscritos: MutableList<Usuario>,
        ) {
    fun matricular(usuario: Usuario) = this.inscritos.add(usuario)
    fun adicionarCurso(curso: ConteudoEducacional) = this.cursos.add(curso)

}

fun matricularAlunoEmFormacao(aluno: Usuario, formacao: Formacao) {
    formacao.matricular(aluno)
}

fun main() {
    val joao = Usuario(
            "1",
            "João da Silva",
            "123.456.789-10",
            "01/02/2003",
    )

    val maria = Usuario(
            "2",
            "Maria da Silva",
            "321.654.987-01",
            "20/01/2003",
    )

    val introducaoKotlin = ConteudoEducacional(
            "Introdução ao Kotlin",
            60,
            Nivel.BASICO,
    )

    val orientacaoObjetosKotlin = ConteudoEducacional(
            "Orientação a Objetos para Kotlin",
            90,
            Nivel.INTERMEDIARIO,
    )

    val paradigmaFuncionalKotlin = ConteudoEducacional(
            "Kotlin e funções",
            120,
            Nivel.DIFICIL,
    )

    val cursosKotlin = mutableListOf<ConteudoEducacional>()
    val matriculados = mutableListOf<Usuario>()

    val kotlin = Formacao(
            "Profissional Kotlin",
            cursosKotlin,
            matriculados
    )

    kotlin.matricular(joao)
    kotlin.adicionarCurso(introducaoKotlin)
    kotlin.adicionarCurso(orientacaoObjetosKotlin)
    kotlin.adicionarCurso(paradigmaFuncionalKotlin)

    maria.let {maria ->
        matricularAlunoEmFormacao(maria, kotlin)
    }


    print(kotlin.nome)
    print(kotlin.cursos)
    print(kotlin.inscritos)

}
