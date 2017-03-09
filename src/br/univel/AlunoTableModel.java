package br.univel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AlunoTableModel extends AbstractTableModel {

	private List<Aluno> lista;

	public AlunoTableModel(List<Aluno> lista) {
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {

		// retorna 2 pq tem somente id e nome;
		return 2;
	}

	@Override
	public int getRowCount() {

		// cada aluno na lista representa uma linha
		// na tabela.
		return lista.size();
	}

	@Override
	public String getColumnName(int column) {

		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		}
		
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Aluno a = lista.get(row);
		switch (column) {
		case 0:
			return a.getId();
		case 1:
			return a.getNome();

		}
		return "coluna inexistente";
	}

}