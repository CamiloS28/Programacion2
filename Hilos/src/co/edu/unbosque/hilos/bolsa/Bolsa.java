package co.edu.unbosque.hilos.bolsa;

import java.util.ArrayList;

public class Bolsa {

	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	public void addProducto(Producto producto) {

		if (!estaLlena()) {
			System.out.println("Agregando Producto");
			listaProductos.add(producto);
		}
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;

	}

	public int getSize() {
		return listaProductos.size();
	}

	public boolean estaLlena() {

		return listaProductos.size() >= 5;
	}
}