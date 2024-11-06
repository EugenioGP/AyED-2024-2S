package tp5.ejercicio1;

import java.util.List;

public interface Graph<T> {

	/**
	 * Crea un vértice con el dato recibido y lo retorna.
	 * 
	 * @param data Dato que contendrá el nuevo vértice
	 */
	public Vertex<T> createVertex(T data);
	
	/**
	 * Elimina el vértice del Grafo.
	 * En caso que el vértice esté relacionado con otros, estas relaciones también se eliminan.
	 * 
	 * @param vertex Vértice a eliminar
	 */
	public void removeVertex(Vertex<T> vertex);
	
	/**
	 * Busca y retorna el primer vértice cuyo dato es igual al parámetro recibido.
	 * Retorna null si no existe tal.
	 * 
	 * @param data Contenido del vértice
	 * @return Vertice o null si no existe tal
	 */
	public Vertex<T> search(T data);
	
	/**
	 * Conecta el vértice origen con el vértice destino.
	 * Verifica que ambos vértices existan, caso contrario no realiza ninguna conexión.
	 * 
	 * @param origin
	 * @param destination
	 */
	public void connect(Vertex<T> origin, Vertex<T> destination);
	
	/**
	 * Conecta el vertice origen con el destino con peso.
	 * Verifica que ambos vertices existan, caso contrario no realiza ninguna conexion
	 * 
	 * @param origin
	 * @param destination
	 * @param weight
	 */
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight);
	
	/**
	 * Desconecta el vértice origen con el destino.
	 * Verifica que ambos vértices existan, caso contrario no realiza ninguna desconexión
	 * En caso de existir la conexión destino-->origen, esta permanecerá sin cambios. 
	 * 
	 * @param origin
	 * @param destination
	 */
	public void disconnect(Vertex<T> origin, Vertex<T> destination);
	
	/**
	 * Retorna true si existe una arista entre el vértice origen y el destino.
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination);
	
	/**
	 * Retorna el peso entre dos vértices.
	 * En caso de no existir la arista retorna 0.
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	public int weight(Vertex<T> origin, Vertex<T> destination);

	/**
	 * Retorna si el grafo no contiene datos (sin vértices creados).
	 * 
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Retorna la lista de vértices.
	 * 
	 * @return
	 */
	public List<Vertex<T>> getVertices();
		
	/**
	 * Retorna la lista de adyacentes al vértice recibido.
	 * 
	 * @param v
	 * @return
	 */
	public List<Edge<T>> getEdges(Vertex<T> v);
	
	/**
	 * Obtiene el vértice para la posición recibida.
	 * 
	 * @param position
	 * @return
	 */
	public Vertex<T> getVertex(int position);
	
	/**
	 * Retorna la cantidad de vértices del grafo
	 * 
	 * @return
	 */
	public int getSize();

}
