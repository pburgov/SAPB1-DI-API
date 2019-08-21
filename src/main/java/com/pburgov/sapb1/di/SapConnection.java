package com.pburgov.sapb1.di;

import com.sap.smb.sbo.api.ICompany;
import com.sap.smb.sbo.api.SBOCOMConstants;
import com.sap.smb.sbo.api.SBOCOMUtil;
import com.sap.smb.sbo.api.SBOErrorMessage;

public class SapConnection {

    private ICompany iCompany;
    private int connectionResult = -1;
    private static final String SAP_SERVER = "XXX.XXX.XXX.XXX";
    private static final String SAP_COMPANY_DB_NAME = "COMPANY_NAME";
    private static final String SAP_USER_NAME = "sap_user_name";
    private static final String SAP_USER_PASSWORD = "sap_user_password";
    private static final String DB_USER_NAME = "db_user_password";
    private static final String DB_USER_PASSWORD = "db_user_password";

    public void connect() {
        try {
            iCompany = SBOCOMUtil.newCompany();
            setICompany(iCompany);
            iCompany.setServer(SAP_SERVER);
            iCompany.setCompanyDB(SAP_COMPANY_DB_NAME);
            iCompany.setUserName(SAP_USER_NAME);
            iCompany.setPassword(SAP_USER_PASSWORD);
            iCompany.setDbServerType(SBOCOMConstants.BoDataServerTypes_dst_MSSQL2008);
            iCompany.setUseTrusted(false);
            iCompany.setLanguage(SBOCOMConstants.BoSuppLangs_ln_Spanish);
            iCompany.setDbUserName(DB_USER_NAME);
            iCompany.setDbPassword(DB_USER_PASSWORD);
            iCompany.setLicenseServer("SRV-SAP:30000");

            connectionResult = iCompany.connect();
            if ( connectionResult == 0 ) {
                System.out.println("SAP connection: Successfully connected to " + iCompany.getCompanyName());
            } else {
                SBOErrorMessage errMsg = iCompany.getLastError();
                System.out.println("SAP connection:Cannot connect to server: " + errMsg.getErrorMessage() + " "
                                       + errMsg.getErrorCode());
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            connectionResult = -1;
        }
    }

    public void disconnect() {
        if ( getConnectionResult() == 0 ) {
            if ( iCompany.isInTransaction() ) {
                iCompany.endTransaction(SBOCOMConstants.BoWfTransOpt_wf_RollBack);
            }
            iCompany.disconnect();
            System.out
                .println("SAP connection: Application disconnected successfully from " + iCompany.getCompanyName());
            iCompany = null;
        }
    }

    private int getConnectionResult() {
        return connectionResult;
    }

    public ICompany getICompany() {
        return iCompany;
    }

    private void setICompany( ICompany company ) {
        this.iCompany = company;
    }

}
