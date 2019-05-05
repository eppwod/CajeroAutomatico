
public class CuentaBancaria {
	// Atributos

	private String ccc;
	private int numEntidad;
	private int numOficina;
	private int numControl;
	private long numCuenta;
	private double saldoCuenta = 1500.87;
	String titular;

	// Constructor
	public CuentaBancaria(String titular, String ccc) { // CCC = Código de cuenta completo, 20 dígitos

		this.titular = titular;
		this.ccc = ccc;
	}

	public String getCCC() {
		return this.ccc;
	}

	public void setEntidad() {
		this.numEntidad = Integer.parseInt(this.ccc.substring(0, 4));
	}

	public int getEntidad() {
		return this.numEntidad;
	}

	public void setOficina() {
		this.numOficina = Integer.parseInt(this.ccc.substring(4, 8));
	}

	public int getOficina() {
		return this.numOficina;
	}

	public void setControl() {
		this.numControl = Integer.parseInt(this.ccc.substring(8, 10));
	}

	public int getControl() {
		return this.numControl;
	}

	public void setCuenta() {
		this.numCuenta = Long.parseLong(this.ccc.substring(10, 20));
	}

	public long getCuenta() {
		return this.numCuenta;
	}

	public void setSaldo(double saldo) {
		this.saldoCuenta = Math.round(saldo * 100.0) / 100.0;
	}

	public double getSaldo() {

		return Math.round(this.saldoCuenta * 100.0) / 100.0;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTitular() {
		return this.titular;
	}

	public Boolean comprobarControl() {

		Boolean salida;
		int digitoCorrecto1;
		int digitoCorrecto2;

		int resto1 = ((Integer.parseInt(this.ccc.substring(0, 1)) * 4) // Primera cifra de la Entidad * 4
				+ (Integer.parseInt(this.ccc.substring(1, 2)) * 8) // Segunda cifra de la Entidad * 8
				+ (Integer.parseInt(this.ccc.substring(2, 3)) * 5) // Tercera cifra de la Entidad * 5
				+ (Integer.parseInt(this.ccc.substring(3, 4)) * 10) // Cuarta cifra de la Entidad * 10
				+ (Integer.parseInt(this.ccc.substring(4, 5)) * 9) // Primera cifra de la Sucursal * 9
				+ (Integer.parseInt(this.ccc.substring(5, 6)) * 7) // Segunda cifra de la Sucursal * 7
				+ (Integer.parseInt(this.ccc.substring(6, 7)) * 3) // Tercera cifra de la Sucursal * 3
				+ (Integer.parseInt(this.ccc.substring(7, 8)) * 6)) // Cuarta cifra de la Sucursal * 6
				% 11; // Se divide entre 11 y nos quedamos con el resto de la división

		if (11 - resto1 < 10) { // Si (11 - resto1 < 10) el dígito es correcto
			digitoCorrecto1 = (int) (11 - resto1);
		} else if (11 - resto1 == 11) {
			digitoCorrecto1 = 0;
		} else if (11 - resto1 == 10) {
			digitoCorrecto1 = 1;
		}

		else {
			digitoCorrecto1 = 000;
			salida = false;
		}

		int resto2 = ((Integer.parseInt(this.ccc.substring(10, 11)) * 1) // Primera cifra de la Cuenta * 1
				+ (Integer.parseInt(this.ccc.substring(11, 12)) * 2) // Segunda cifra de la Cuenta * 2
				+ (Integer.parseInt(this.ccc.substring(12, 13)) * 4) // Tercera cifra de la Cuenta * 4
				+ (Integer.parseInt(this.ccc.substring(13, 14)) * 8) // Cuarta cifra de la Cuenta * 8
				+ (Integer.parseInt(this.ccc.substring(14, 15)) * 5) // Quinta cifra de la Cuenta * 5
				+ (Integer.parseInt(this.ccc.substring(15, 16)) * 10) // Sexta cifra de la Cuenta * 10
				+ (Integer.parseInt(this.ccc.substring(16, 17)) * 9) // Séptima cifra de la Cuenta * 9
				+ (Integer.parseInt(this.ccc.substring(17, 18)) * 7) // Octava cifra de la Cuenta * 7
				+ (Integer.parseInt(this.ccc.substring(18, 19)) * 3) // Novena cifra de la Cuenta * 3
				+ (Integer.parseInt(this.ccc.substring(19, 20)) * 6)) // Décima cifra de la Cuenta * 6
				% 11; // Se divide entre 11 y nos quedamos con el resto de la división

		if (11 - resto2 < 10) { // Si (11 - resto2 < 10) el dígito es correcto
			digitoCorrecto2 = (int) (11 - resto2);
		}

		else if (11 - resto2 == 11) {
			digitoCorrecto2 = 0;
		}

		else if (11 - resto2 == 10) {
			digitoCorrecto2 = 1;
		}

		else {
			digitoCorrecto2 = 000;
			salida = false;
		}

		if ((digitoCorrecto1 == Integer.parseInt(this.ccc.substring(8, 9)))
				&& (digitoCorrecto2 == Integer.parseInt(this.ccc.substring(9, 10)))) {
			salida = true;
		} else {
			salida = false;
		}
		return salida;
	}

	public void retirarSaldo(double cantidad) {
		this.saldoCuenta = Math.round((this.saldoCuenta - cantidad) * 100.0) / 100.0;
	}

	public void ingresarSaldo(double cantidad) {
		this.saldoCuenta = Math.round((this.saldoCuenta + cantidad) * 100.0) / 100.0;
	}
}
