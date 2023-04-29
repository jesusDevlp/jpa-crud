package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import model.Tipo;
import model.Usuario;

public class JPATest01 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_sesion01");
		EntityManager em = fabrica.createEntityManager();

		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------");
		System.out.println("MENÚ");
		System.out.println("INGRESE LAS LETRAS EN MAYUSCULA" + "\n A - PARA MOSTRAR LOS USUARIOS REGISTRADOS"
				+ "\n B - PARA INGRESAR UN NUEVO USUARIO" + "\n C - PARA BUSCAR UN USUARIO"
				+ "\n D - PARA ACTUALIZAR UN USUARIO" + "\n E - PARA ELIMINAR UN USUARIO" + "\n F - SALIR");

		String answer = (scan.next());

		switch (answer) {
		case "A": // mostrar todos los usuarios
			System.out.println("----- USUARIOS REGISTRADOS EN LA BASE DE DATOS -----");

			List<Usuario> lstUsuarios = em.createQuery("Select a From Usuario a", Usuario.class).getResultList();
			System.out.println("==============================================");

			/* Listar todos los usuarios */
			for (Usuario u : lstUsuarios) {
				System.out.println("                              ");
				System.out.println("Codigo Usuario: " + u.getCodUsua());
				System.out.println("Usuario: " + u.getNomUsua());
				System.out.println("Apellido: " + u.getApeUsua());
				System.out.println("Clase Usuario: " + u.getClaUsua());
				System.out.println("Fecha Nacimiento: " + u.getFnaUsua());
				System.out.println("Tipo: " + u.getTbTipo());
				System.out.println("Estado:" + u.getEstUsua());
				System.out.println("==============================================");
			}

			/* Mostrar cantidad de usuarios */
			System.out.println("Número de usuarios:" + lstUsuarios.size());
			System.out.println("==============================================");

			break;

		case "B": // para ingresar usuarios
			System.out.println("Ingrese el nombre");
			Usuario user = new Usuario();
			Tipo tipo = new Tipo();
			user.setCodUsua(6);
			scan.nextLine();
			user.setNomUsua(scan.next());

			System.out.println("Ingrese el apellido");
			user.setApeUsua(scan.next());

			System.out.println("Ingrese el correo");
			user.setUsrUsua(scan.next());

			System.out.println("Ingrese la clase");
			user.setClaUsua(scan.next());

			System.out.println("Ingrese la fecha nacimiento");
			user.setFnaUsua(scan.next());

			System.out.println("Ingrese el tipo");
			//user.setTbTipo(tbTipo);

			System.out.println("Ingrese el estado");
			user.setEstUsua(scan.nextInt());

			System.out.println(user);
			em.persist(user);
			em.getTransaction().commit();
			System.out.println("Usuario Registrado con éxito");
			System.out.println();

			break;

		case "C":
			System.out.println("Digite el id del usuario que desea buscar");
			user = new Usuario();
			user = em.find(Usuario.class, scan.nextInt());
			if (user != null) {
				System.out.println("Codigo Usuario: " + user.getCodUsua());
				System.out.println("Usuario: " + user.getNomUsua());
				System.out.println("Apellido: " + user.getApeUsua());
				System.out.println("Clase Usuario: " + user.getClaUsua());
				System.out.println("Fecha Nacimiento: " + user.getFnaUsua());
				System.out.println("Tipo: " + user.getTbTipo());
				System.out.println("Estado:" + user.getEstUsua());
				System.out.println();
			} else {
				System.out.println();
				System.out.println("Usuario no encontrado");
				List<Usuario> lsUsuario = new ArrayList<>();
				Query query = em.createQuery("Select a From Usuario a");
				lstUsuarios = query.getResultList();
				for (Usuario a : lstUsuarios) {
					System.out.println(a);
				}

				System.out.println();

			}

			break;

		case "D":
			System.out.println("Digite el id del usuario que desea actualizar");
			user = new Usuario();
			user = em.find(Usuario.class, scan.nextInt());

			break;

		case "E":
			System.out.println("Digite el id del usuario que desea eliminar");
			user = new Usuario();
			user = em.find(Usuario.class, scan.nextInt());

			if (user != null) {
				System.out.println("Codigo Usuario: " + user.getCodUsua());
				System.out.println("Usuario: " + user.getNomUsua());
				System.out.println("Apellido: " + user.getApeUsua());
				System.out.println("Clase Usuario: " + user.getClaUsua());
				System.out.println("Fecha Nacimiento: " + user.getFnaUsua());
				System.out.println("Tipo: " + user.getTbTipo());
				System.out.println("Estado:" + user.getEstUsua());
				em.getTransaction().begin();
				em.remove(user);
				em.getTransaction().commit();
				System.out.println("Usuario eliminado correctamente");
			} else {
				System.out.println("Usuario no encontrado");
			}

			break;

		case "F":
			em.close();

			break;

		default:
			System.out.println("Opcion no valida\n");
			break;
		}

	}

}
