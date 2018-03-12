package Paises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 
public class Pais {
	int id;
	String nome;
	long populacao;
	double area;


	public Pais(int id, String nome, long populacao, double area) {
		
      
		super();
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
   
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
   
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	
   
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "ID: " + id + " Nome: " + nome + "População: " + populacao + "Area: " + area;
	}
										/* CRUD */
	static {
		try {
	Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
	throw new RuntimeException(e);
	}
	}
	public Connection obtemConexao() throws SQLException {
	return DriverManager
	.getConnection("jdbc:mysql://localhost/Pais?user=root&password=luc.conte");
	}
										  /* INCLUI */
	
   
	public void incluir(int id, String nome, long populacao, double area) {
	String sqlInsert = "INSERT INTO pais(int id, String nome, long populacao, double area) VALUES (?, ?, ?, ?)";
			try (Connection conn = obtemConexao();
	PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		stm.setInt   (1, id);
		stm.setString(2, nome);
		stm.setLong  (3, populacao);
		stm.setDouble(4, area);
	stm.execute();
		} catch (SQLException e) {
		e.printStackTrace();
	}
	}
										/* ATUALIZA */
	public void atualizar(int id, String nome, long populacao, double area) {
	String sqlUpdate = "UPDATE pais SET nome=?, area=?, populacao=? WHERE id=?";
		    try (Connection conn = obtemConexao();
	PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
		stm.setInt   (1, id);
		stm.setString(2, nome);
		stm.setLong  (3, populacao);
		stm.setDouble(4, area);
		stm.execute();
		} catch (Exception e) {
		e.printStackTrace();
	}
	}
										/* DELETA */
	public void excluir(int id){
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
			try(Connection conn = obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt   (1, id);
			stm.execute  ();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
										/* maiorPopulacao */
	
   public void maiorPopulacao() {
		String sqlMaxPop = "SELECT * FROM paises WHERE populacao = (SELECT MAX(populacao) FROM pais)";
		try (Connection conn = obtemConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlMaxPop);	
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				setNome(rs.getString("nome"));
				setPopulacao(rs.getLong("populacao"));
				setId(rs.getInt("id"));
				setArea(rs.getDouble("area"));
			}else {
				System.out.println("Error Result Set");
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
										/* menorArea */
                              
     	public void menorArea() {
		String sqlGet = "SELECT * FROM pais WHERE area = (SELECT Min(area) FROM pais)";
		try (Connection conn = obtemConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlGet);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				setNome(rs.getString    ("nome"));
				setPopulacao(rs.getLong ("populacao"));
				setId(rs.getInt			("id"));
				setArea(rs.getDouble    ("area"));
			}else {
				System.out.println("ERROR RESULT SET");
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
										/* vetorTresPaises */
	
   
	public String[] vetorTresPaises() {	
		String sqlGet = "SELECT nome FROM paises ORDER BY nome";
		String[] array = new String[3];
		int cont = 0 ;
		try (Connection conn = obtemConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlGet);
			ResultSet rs = stm.executeQuery();
			while(rs.next() && cont < 3 ) {
				array[cont] = rs.getString("nome");
				cont ++;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}	
		return array;
	}
	}
