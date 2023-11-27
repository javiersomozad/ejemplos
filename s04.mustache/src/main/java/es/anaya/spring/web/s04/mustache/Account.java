package es.anaya.spring.web.s04.mustache;

public class Account {
		private Long id;
		private String bank;
		private String number;
		private Boolean active;
		private Double balance;
		
		public Account () {}
		
		public Account(Long id, String bank, String number, Boolean active, Double balance) {
			this.id = id;
			this.bank = bank;
			this.number = number;
			this.active = active;
			this.balance = balance;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getBank() {
			return bank;
		}

		public void setBank(String bank) {
			this.bank = bank;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		
		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}

		public Double getBalance() {
			return balance;
		}

		public void setBalance(Double balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "Account [id=" + id + ", bank=" + bank + ", number=" + number + ", active=" + active + ", balance="
					+ balance + "]";
		}
}
