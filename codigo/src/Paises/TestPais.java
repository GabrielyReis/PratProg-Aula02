package Paises;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class TestPais {
	Pais pais,copia;
	static int id = 5;
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println	("Setup");
		pais  = new Pais	(id,"TestePais", 1541400, 24841.00);
		copia = new Pais	(id,"TestePais",1541400, 24841.00);
		System.out.println	(pais);
		System.out.println	(copia);
	}
	@Test
	public void test01Incluir() {
		System.out.println	("Incluir");
		pais.incluir(0, null, 0, 0);
		id = pais.getId();
		copia.setId(id);
		assertEquals(pais.getId(),copia.getId(),"TESTE CRIAR");
	}
	@Test
	public void test02Atualizar() {
		System.out.println	("atualizar");
		pais.setNome		(null);
		copia.setNome		(null);
		pais.atualizar(0, null, 0, 0);
		assertEquals(pais.getNome(),copia.getNome(),"TESTE ATUALIZAR");
	}
	@Test
	public void test03Excluir() {
		System.out.println	("Excluir");
		pais.setId(id);
		copia.setId(-1);
		pais.excluir(0);
		assertEquals(pais.getId(),copia.getId(),"TESTE EXCLUIR");
	}
	@Test
	public void test04MaiorPopulacao() {
		System.out.println("Maior populacao");
		pais.maiorPopulacao();
		long populacao = pais.getPopulacao();
		copia.setPopulacao(populacao);
		assertEquals(pais.getPopulacao(),copia.getPopulacao(),"TESTE MAIOR POPULACAO");
	}	
	@Test
	public void test05MenorArea() {
		System.out.println	("menorArea");
		pais.menorArea();
		double area = pais.getArea();
		copia.setArea(area);
		assertEquals(pais.getArea(),copia.getArea(),"TESTE MENOR AREA");
	}
	public void test06Vetor() {
		System.out.println	("VETOR DE PAISES");
		String [] array = pais.vetorTresPaises();
		assertEquals(array.length,3,"TESTE VETOR");
	}
}