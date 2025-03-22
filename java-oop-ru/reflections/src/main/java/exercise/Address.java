package exercise;

class Address {
	// BEGIN
	@MinLength(minLength = 4)
	@NotNull
	// END
	private String country;

	// BEGIN
	@MinLength
	@NotNull
	// END
	private String city;

	// BEGIN
	@MinLength
	@NotNull
	// END
	private String street;

	// BEGIN
	@NotNull
	// END
	private String houseNumber;

	private String flatNumber;

	Address(String country, String city, String street, String houseNumber, String flatNumber) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.flatNumber = flatNumber;
	}
}
