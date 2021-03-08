package es.urjc.code.dad.xkeys_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.urjc.code.dad.xkeys_web.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	Producto findById(long id);
	
	@Query("SELECT p FROM Producto p WHERE p.plataforma= ?1")
	List<Producto> filterByPlataforma(String plataforma);	
	
	@Query("SELECT p FROM Producto p WHERE p.precio >= ?1 AND p.precio <= ?2")
	List<Producto> filterByPrecio(int precio, int precio2);
	
	@Query("SELECT p FROM Producto p WHERE p.categoria= ?1")
	List<Producto> filterByCategoria(String categoria);
	
	@Query("SELECT p FROM Producto p WHERE p.nombre LIKE ?1%")
	List<Producto> filterByBusqueda(String busqueda);
}