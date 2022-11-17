package Data;

public class UserData {
    private String name = "kirillliga";
    private String email = "vladimir.liga@liga.com";
    private String password = "vladimirliga123";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserData(int countSymbolsName, int countSymbolsEmail, int countSymbolsPassword){
        name = UserDataGenerate.getRandomName(countSymbolsName);
        email = UserDataGenerate.getRandomEmail(countSymbolsEmail);
        password = UserDataGenerate.getRandomPassword(countSymbolsPassword);
    }

    public UserData(){

    }



}
