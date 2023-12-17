package FlatProject.actions;

public class FileConvertor {/*
    public static void exportToTxtFile(String fileName, String data) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write(data);
        }
    }

    public static void exportToSerializableFile(String fileName, Flat flat) throws IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(flat);
        }
    }

    public static Flat importFromSerializableFile(String fileName) throws IOException, ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (Flat) ois.readObject();
        }
    }

    public static Flat importFromJsonFile(String fileName) throws IOException, FlatException{
        Flat flat = null;
        try{
            // validateJsonFile(fileName, "schema.json");

            String jsonData = new String(Files.readAllBytes(new File(fileName).toPath()));
            JSONObject jsonObject = new JSONObject(jsonData);

            JSONObject jBank = jsonObject.getJSONObject("bank");
            bank = parseBankObject(jBank);

            JSONArray jClients = jBank.getJSONArray("clients");
            for (int i = 0; i < jClients.length(); i++)
                bank.registerClient(parseClientObject(jClients.getJSONObject(i)));

            JSONArray jEmployees = jBank.getJSONArray("employees");
            for (int i = 0; i < jEmployees.length(); i++)
                bank.recruitEmployee(parseEmployeeObject(jEmployees.getJSONObject(i)));

        }
        catch (IOException | JSONException ex){
            throw new BankException("Error reading JSON file:" + ex.getMessage(), bank);
        }
        return bank;
    }

    private static Bank parseBankObject(JSONObject object) throws BankException{
        String name = object.getString("name");
        String bic = object.getString("BIC");
        return new Bank(name, bic);
    }

    private static Client parseClientObject(JSONObject object) throws BankException{
        String name = object.getString("name");
        String birthday = object.getString("birthdate");
        String gender = object.getString("gender");
        double sum = object.getDouble("sum");
        return new Client(name, birthday, gender, sum);
        //(String name, String birthdate, String gender, Double sum)
    }

    private static Employee parseEmployeeObject(JSONObject object) throws BankException{
        String name = object.getString("name");
        String birthday = object.getString("birthdate");
        String gender = object.getString("gender");
        String department = object.getString("department");
        return new Employee(name, birthday, gender, department);
    }

    private static void validateJsonFile(String fileName, String schemaFile) throws IOException, JSONException{
        String schemaData = new String(Files.readAllBytes(Paths.get(schemaFile)));
        JSONObject rawSchema = new JSONObject(new JSONTokener(schemaData));
        Schema schema = SchemaLoader.load(rawSchema);

        String jsonData = new String(Files.readAllBytes(new File(fileName).toPath()));
        JSONObject jsonToValidate = new JSONObject(new JSONTokener(jsonData));

        schema.validate(jsonToValidate);
    }
*/

}
