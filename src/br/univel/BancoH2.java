package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BancoH2 implements BancoTe {

	private static Connection con;
	public static int id = 0;
	@Override
	public  List<Aluno> carregarTodos() {
		List<Aluno> lista = new ArrayList<>();
		String sql = "select * from  aluno;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

	public BancoH2() {
		String url = "jdbc:h2:~/test", user = "sa", senha = "sa";
		try {
			con = DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void inserirVarios(Aluno a) {
		String sql = "insert into aluno (id, nome) values (?, ?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static int checar(int num){
		List<Aluno> alunos = new ArrayList<>();
		alunos = buscarTodos();
		for (Aluno aluno : alunos) {
				num = aluno.getId();
		}
		return num+1;
	}
	
	public static void conectar() {
		String url = "jdbc:h2:~/test", user = "sa", pass = "sa";
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println("CONECTADO");
	}

	public static void desconectar() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void Inserir(String nome,int id) {
		String sql = "insert into aluno (id, nome) values (?, ?)";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, nome);
			ps.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Numero invalido checar lista");
		}
	}

	public static void atualizar(String nome, int id) {
		String sql = "update aluno set nome = ? where id = ?";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void Apagar(int id) {
		String sql = "DELETE FROM ALUNO WHERE ID = ?;";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Aluno> buscarTodos() {
		List<Aluno> lista = new ArrayList<>();
		String sql = "select * from  aluno;";
		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
				lista.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}



}