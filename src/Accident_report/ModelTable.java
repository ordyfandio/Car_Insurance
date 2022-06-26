package Accident_report;


public class ModelTable {
    
    
    String txtmatricule,txtreport,txtlocation,txtdate,txttime;

    public ModelTable(String txtmatricule, String txtreport, String txtlocation, String txtdate, String txttime) {
        this.txtmatricule = txtmatricule;
        this.txtreport = txtreport;
        this.txtlocation = txtlocation;
        this.txtdate = txtdate;
        this.txttime = txttime;
        
        
    }

    public String getTxtmatricule() {
        return txtmatricule;
    }

    public void setTxtmatricule(String txtmatricule) {
        this.txtmatricule = txtmatricule;
    }
    
    public String getTxtreport() {
        return txtreport;
    }
    
    public void setTxtreport(String txtreport) {
        this.txtreport = txtreport;
    }
    
    public String getTxtlocation() {
        return txtlocation;
    }
    
    public void setTxtlocation(String txtlocation) {
        this.txtlocation = txtlocation;
    }
    
     public String getTxtdate() {
        return txtdate;
    }
    
    public void setTxtdate(String txtdate) {
        this.txtdate = txtdate;
    }
    
    public String getTxttime() {
        return txttime;
    }
    
    public void setTxttime(String txttime) {
        this.txttime = txttime;
    }    

}
