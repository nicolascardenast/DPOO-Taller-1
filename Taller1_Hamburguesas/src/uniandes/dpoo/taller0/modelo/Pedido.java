package uniandes.dpoo.taller0.modelo;

import java.io.File;
import java.util.ArrayList;

/**
 * Esta clase encapsula la información de un pedido y la guarda
 * en el archivo correspondiente.
 */
public class Pedido {

	/**
	 * Pendientes:
	 *  > Método guardarFactura().
	 *  > Asignar valor a idPedido.
	 */
	
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/**
	 * Cantidad total de pedidos realizados.
	 */
	private static int numeroPedidos;
	
	/**
	 * ID del pedido.
	 */
	private int idPedido;
	
	/**
	 * Nombre del cliente.
	 */
	private String nombreCliente;
	
	/**
	 * Dirección del cliente.
	 */
	private String direccionCliente;
	
	/**
	 * Lista que contiene los ítems del pedido.
	 */
	private ArrayList<Producto> itemsPedido;
	
	
	// ************************************************************************
	// Constructores
	// ************************************************************************
	
	/**
	 * Construye un nuevo pedido e inicializa sus atributos con la información de
	 * los parámetros.
	 * 
	 * @param nombreCliente Nombre del cliente.
	 * @param direccionCliente Dirección del cliente.
	 */
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.itemsPedido = new ArrayList<>();
		this.idPedido = (numeroPedidos + 1);
	}
	
	
	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************
	
	/**
	 * Consulta el ID del pedido.
	 * 
	 * @return idPedido
	 */
	public int getIdPedido () {
		return idPedido;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public String getDireccionCliente() {
		return direccionCliente;
	}
	
	
	// ************************************************************************
	// Otros métodos
	// ************************************************************************
	
	/** Añade un ítem a la lista de pedidos.
	 * 
	 * @param nuevoItem El ítem que se quiere añadir.
	 */
	public void agregarProducto(Producto nuevoItem) {
		itemsPedido.add(nuevoItem);
	}
	
	/**
	 * Calcula el precio neto (sin IVA) del pedido.
	 * 
	 * @return precioNeto
	 */
	private int getPrecioNetoPedido() {
		int precioNeto = 0;
		for (Producto item:itemsPedido) {
			precioNeto += item.getPrecio();
		}
		return precioNeto;
	}
	
	/**
	 * Calcula el valor del IVA sobre el pedido.
	 * 
	 * @return valorIva
	 */
	private int getPrecioIVAPedido() {
		return (int) Math.round((getPrecioNetoPedido() * 0.19));
	}
	
	/**
	 * Calcula el valor total del pedido (neto + IVA).
	 * 
	 * @return Precio total del pedido.
	 */
	private int getPrecioTotalPedido() {
		return (getPrecioNetoPedido() + getPrecioIVAPedido());
	}
	
	/**
	 * Genera la factura del pedido.
	 * 
	 * @return factura
	 */
	private String generarTextoFactura() {
		String factura = "\nGracias por su pedido. La factura es la siguiente:";
		for (Producto item:itemsPedido) {
			factura += item.generarTextoFactura();
		}
		factura += "\n\n" + "Valor neto" + "\t" + getPrecioNetoPedido();
		factura += "\n" + "IVA" + "\t" + getPrecioIVAPedido();
		factura += "\n\n" + "Valor total" + "\t" + getPrecioTotalPedido();		
		return factura;
	}
	
	/**
	 * Añade una factura al texto respectivo.
	 * 
	 * @param archivo
	 */
	public void guardarFactura(File archivo) {
		String factura = generarTextoFactura();
		System.out.println(factura);
		//TODO Hacer este gran puto método.
		numeroPedidos ++;
	}

}
