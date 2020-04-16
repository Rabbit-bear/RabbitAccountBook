package Service.Impl;

import DAO.Importer;
import Entity.UserAccount;
import Service.ImportDataService;

public class ImportDataServiceImpl implements ImportDataService {
    Importer importer = new Importer();
    @Override
    public UserAccount getUserAccount() {
        return importer.start();
    }

}
