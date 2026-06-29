public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        if (contactId == null || contactId.isEmpty() || contactId.length() > 10) {
            throw new IllegalArgumentException(
                "contactId must not be null, must not be empty, and must be 10 characters or fewer.");
        }
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "firstName must not be null, must not be empty, and must be 10 characters or fewer.");
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "lastName must not be null, must not be empty, and must be 10 characters or fewer.");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "phone must not be null and must be exactly 10 digits.");
        }
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException(
                "address must not be null, must not be empty, and must be 30 characters or fewer.");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.phone     = phone;
        this.address   = address;
    }

    public String getContactId() { return contactId; }
    public String getFirstName()  { return firstName; }
    public String getLastName()   { return lastName; }
    public String getPhone()      { return phone; }
    public String getAddress()    { return address; }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty() || firstName.length() > 10) {
            throw new IllegalArgumentException(
                "firstName must not be null, must not be empty, and must be 10 characters or fewer.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty() || lastName.length() > 10) {
            throw new IllegalArgumentException(
                "lastName must not be null, must not be empty, and must be 10 characters or fewer.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                "phone must not be null and must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30) {
            throw new IllegalArgumentException(
                "address must not be null, must not be empty, and must be 30 characters or fewer.");
        }
        this.address = address;
    }
}