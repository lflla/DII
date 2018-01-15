package interfaceDAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public interface IDAOManagement {
    
    
    
    
    
    public void create(Object a);
	
    public void update(Object a);
    
    public void delete(Object a);
    
    public ArrayList readAll();
    
    public void saveInFile();
    
    public boolean read(Object a);
    
}
