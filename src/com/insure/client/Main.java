package com.insure.client;

import com.insure.client.gen.*;
import cryptography.Signature;

import javax.swing.*;
import javax.xml.ws.BindingProvider;
import java.lang.Exception;

//Wsimport.bat -s ..\src -keep -p com.insure.client.gen "http://localhost:8090/claimservice?wsdl"

public class Main {
    public static final String INSERT_CLAIM_ID = "Insert claim id: ";
    public static final String INSERT_DOCUMENT_ID = "Insert document id: ";

    public static void main(String[] args) throws Exception {
            Signature signature = new Signature();
            String url = "http://localhost:8090/claimservice";
            ClaimDataStoreService dss = new ClaimDataStoreService();
            //docStorage -> Claim data store
            ClaimDataStore docStorage = dss.getClaimDataStorePort();
            ((BindingProvider) docStorage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);

            // Client code
            String userId = JOptionPane.showInputDialog("Insert username: ");

            while (true) {
                int claimId;
                int documentId;
                String expression = JOptionPane.showInputDialog("Insert expression (create/update claim) or (list documents or create/read/update/delete document)");
                try {
                    if (expression.equals("exit")) {
                        break;
                    } else if (expression.equals("create claim")) {

                        String claimDescription = JOptionPane.showInputDialog("Insert claim description: ");

                        claimId = docStorage.createClaim(claimDescription, userId);
                        JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));

                    } else if (expression.equals("update claim")) {

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        String newClaimDescription = JOptionPane.showInputDialog("Insert new claim description: ");

                        docStorage.updateClaim(claimId, newClaimDescription);
                        JOptionPane.showMessageDialog(null, docStorage.printClaim(claimId));

                    } else if (expression.equals("list documents")) {

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));

                        printElements(docStorage.listDocumentsOfClaim(claimId).toArray(new String[0]));
                        JOptionPane.showMessageDialog(null, "Output in the command line");

                    } else if (expression.equals("create document")) {

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        String documentContent = JOptionPane.showInputDialog("Insert document content: ");

                        documentId = docStorage.createDocumentOfClaim(claimId, documentContent, userId);
                        String digitalSignature = signature.generate(docStorage.readDocumentOfClaim(claimId, documentId), "keys/" + userId + "PrivateKey");
                        docStorage.signDocumentOfClaim(claimId, documentId, digitalSignature);
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId, documentId));

                    } else if (expression.equals("read document")) {

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId, documentId));

                    } else if (expression.equals("update document")) {

                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));
                        String newDocumentContent = JOptionPane.showInputDialog("Insert new document content: ");

                        docStorage.updateDocumentOfClaim(claimId, documentId, newDocumentContent, userId);
                        JOptionPane.showMessageDialog(null, docStorage.readDocumentOfClaim(claimId, documentId));

                    } else if (expression.equals("delete document")) {
                        claimId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_CLAIM_ID));
                        documentId = Integer.parseInt(JOptionPane.showInputDialog(INSERT_DOCUMENT_ID));

                        docStorage.deleteDocumentOfClaim(claimId, documentId, userId);
                        printElements(docStorage.listDocumentsOfClaim(claimId).toArray(new String[0]));
                        JOptionPane.showMessageDialog(null, "Output in the command line");

                    }

                } catch (Exception e) {
                    e.getMessage();
                }
            }


        }

        public static void printElements(String[] arr) {
            for (String el : arr) {
                System.out.println(el);
            }
        }
}


