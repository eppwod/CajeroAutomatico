import java.util.InputMismatchException;
import java.util.Scanner;

// Ejemplo CCC válido: 53129520767081271946
// Ejemplo CCC válido: 33051088905736941730
// Ejemplo CCC válido: 18329046145736247758

//TODO Restringir número de caracteres nombre
// TODO Restringir a 20 los dígitos del CCC
// TODO Crear excepciones

public class AplicacionCuentaBancaria {
	public static void main(String[] args) {

		while (true) { // Pantalla de bienvenida. Entrada de datos

			@SuppressWarnings("resource")
			Scanner entrada = new Scanner(System.in);

			System.out.println("Porfavor, introduce tu nombre: ");
			String nombre = entrada.nextLine();

			System.out.println("Porfavor, escribe tu número de cuenta completo. CCC (20 dígitos): ");
			String ccc = entrada.nextLine();

			CuentaBancaria miCuenta = new CuentaBancaria(nombre, ccc);

			System.out.println("Comprobando número de cuenta...");
			if (ccc.length() != 20) {
				System.out.println("Número de cuenta incorrecto. Vuelva a introducir los datos: ");
				continue;
			} else if (miCuenta.comprobarControl()) {
				System.out.println("Número de cuenta correcto.");

			} else {
				System.out.println("Número de cuenta incorrecto. Vuelva a introducir los datos: ");
				continue;
			}

			miCuenta.setEntidad();
			miCuenta.setOficina();
			miCuenta.setControl();
			miCuenta.setCuenta();
			miCuenta.setTitular(nombre);

			while (true) { // MENÚ PRINCIPAL

				System.out.println("1.  CONSULTAR NÚMERO DE CUENTA COMPLETO");
				System.out.println("2.  MOSTRAR TITULAR DE LA CUENTA");
				System.out.println("3.  MOSTRAR CÓDIGO DE ENTIDAD");
				System.out.println("4.  MOSTRAR CÓDIGO DE OFICINA");
				System.out.println("5.  MOSTRAR NÚMERO DE CUENTA");
				System.out.println("6.  MOSTRAR DÍGITOS DE CONTROL");
				System.out.println("7.  REALIZAR INGRESO");
				System.out.println("8.  RETIRAR EFECTIVO");
				System.out.println("9.  CONSULTAR SALDO");
				System.out.println("10. SALIR DE LA APLICACIÓN");

				try {
					int opcion = entrada.nextInt();

					if (opcion < 1 | opcion > 10) {
						System.out.println("Selección incorrecta.");
						continue;
					}

					switch (opcion) {
					case 1:
						System.out.println("Número de cuenta completo: " + miCuenta.getCCC());
						break;
					case 2:
						System.out.println("Titular: " + miCuenta.getTitular());
						break;
					case 3:
						System.out.println("Entidad: " + miCuenta.getEntidad());
						break;
					case 4:
						System.out.println("Oficina: " + miCuenta.getOficina());
						break;
					case 5:
						System.out.println("Cuenta: " + miCuenta.getCuenta());
						break;
					case 6:
						System.out.println("Control: " + miCuenta.getControl());
						break;
					case 7:
						System.out.println("Cantidad a ingresar: ");
						double ingreso = entrada.nextDouble();
						miCuenta.ingresarSaldo(ingreso);
						break;
					case 8:
						System.out.println("Cantidad a retirar: ");
						double x = entrada.nextDouble();
						miCuenta.retirarSaldo(x);
						break;
					case 9:
						System.out.println("Saldo: " + miCuenta.getSaldo() + "€");
						break;
					case 10:
						System.exit(0);
					}
				} catch (InputMismatchException e) {
					System.out.println("Selección incorrecta.");
					break;
				}
			}
		}

	}
}
