import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Order {

	private Long id;
	private String empresa;
	private String endereco;
	private String estado;
	private String pais;
	private String email;
	private String vendedor;
	private String ip;
	private BigDecimal valor;
	private LocalDate data;

	public Order() {
	}

	public Order(Long id, String empresa, String endereco, String estado, String pais, String email, String vendedor, String ip,
				 BigDecimal valor, LocalDate data) {
		this.id = id;
		this.empresa = empresa;
		this.endereco = endereco;
		this.estado = estado;
		this.pais = pais;
		this.email = email;
		this.vendedor = vendedor;
		this.ip = ip;
		this.valor = valor;
		this.data = data;
	}

	public static Order wrapCSV(String csvLine) {

		String[] splitedLine = csvLine.split(",");

		return new Order(
				Long.valueOf(splitedLine[0]), //id
				splitedLine[1], //empresa
				splitedLine[2], //endereco
				splitedLine[3], //estado
				splitedLine[4], //pais
				splitedLine[5], //email
				splitedLine[6], //vendedor
				splitedLine[7], //ip
				BigDecimal.valueOf(Double.valueOf(splitedLine[8].replace("$", ""))), //valor
				LocalDate.parse(splitedLine[9], DateTimeFormatter.ofPattern("M/d/yyyy")) //data
		);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(id, order.id) &&
				Objects.equals(empresa, order.empresa) &&
				Objects.equals(endereco, order.endereco) &&
				Objects.equals(estado, order.estado) &&
				Objects.equals(pais, order.pais) &&
				Objects.equals(email, order.email) &&
				Objects.equals(vendedor, order.vendedor) &&
				Objects.equals(ip, order.ip) &&
				Objects.equals(valor, order.valor) &&
				Objects.equals(data, order.data);
	}

	@Override public int hashCode() {
		return Objects.hash(id, empresa, endereco, estado, pais, email, vendedor, ip, valor, data);
	}

	@Override public String toString() {
		return "Order{" +
				"id=" + id +
				", empresa='" + empresa + '\'' +
				", endereco='" + endereco + '\'' +
				", estado='" + estado + '\'' +
				", pais='" + pais + '\'' +
				", email='" + email + '\'' +
				", vendedor='" + vendedor + '\'' +
				", ip='" + ip + '\'' +
				", valor=" + valor +
				", data=" + data +
				'}';
	}

	public String toJson() {
		return "{ \n"
				+ "\"id\":\"".concat(String.valueOf(id)).concat("\",\n")
				+ "\"empresa\":\"".concat(empresa).concat("\",\n")
				+ "\"endereco\":\"".concat(endereco).concat("\",\n")
				+ "\"estado\":\"".concat(estado).concat("\",\n")
				+ "\"pais\":\"".concat(pais).concat("\",\n")
				+ "\"email\":\"".concat(email).concat("\",\n")
				+ "\"vendedor\":\"".concat(vendedor).concat("\",\n")
				+ "\"ip\":\"".concat(ip).concat("\",\n")
				+ "\"valor\":\"".concat(valor.toPlainString()).concat("\",\n")
				+ "\"data\":\"".concat(data.toString()).concat("\"\n")
				+ "}";
	}
}
