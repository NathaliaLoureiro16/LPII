package space.indietech.produto;

public class ProdutoDesconto extends Produto {
	private double valorComDesconto;
	private double desconto;
	

	public double getValorComDesconto() {
		return valorComDesconto;
	}
	public void gerarValorComDesconto() {
		this.valorComDesconto = this.valor - (this.valor *(desconto/100));
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	

}
