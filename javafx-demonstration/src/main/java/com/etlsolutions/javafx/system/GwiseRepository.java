package com.etlsolutions.javafx.system;

import static com.etlsolutions.javafx.system.SettingConstants.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author zc
 */
public final class GwiseRepository {

    private static final GwiseRepository INSTANCE = new GwiseRepository();

    private final Properties properties = new Properties();
    private final ClassLoader loader = ClassLoader.getSystemClassLoader();

    private GwiseRepository() {
    }

    public static GwiseRepository getInstance() {
        return INSTANCE;
    }

    public void initRepository() throws IOException {

        File repositoryDirectory = new File(SettingConstants.REPOSITORY_LOCATION);

        if (!repositoryDirectory.isDirectory()) {

            boolean success = repositoryDirectory.mkdirs();

            if (!success) {
                throw new IOException("Failed to create directory: " + SettingConstants.REPOSITORY_LOCATION);
            }
        }

        File configFile = new File(SettingConstants.REPOSITORY_CONFIG_FILE_PATH);

        if (configFile.exists()) {
            try (FileInputStream in = new FileInputStream(configFile)) {
                properties.load(in);
            }
        }

//TODO: If the files are already there, No need to copy them.

        InputStream in = loader.getResourceAsStream(REPOSITORY_DATA_CONFIG_FILE_PATH);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {

            db = dbf.newDocumentBuilder();
            Document doc = db.parse(in);
            NodeList list = doc.getChildNodes();

            processNodeList(list, "");
        } catch (ParserConfigurationException | SAXException ex) {
            throw new SystemRuntimeExceiption(ex);
        }
        
        ProjectManager.getInstance().init();
    }

    private void processNodeList(NodeList list, String path) throws IOException {

        for (int i = 0; i < list.getLength(); i++) {

            Node item = list.item(i);

            if(item == null) {
                continue;
            }
            
            if (item instanceof Text) {
                Text text = (Text) item;
                String content = text.getTextContent();
                if (content != null && !content.trim().isEmpty()) {
                    String filePath =  path + "/" + content;
                    FileUtils.copyToFile(loader.getResourceAsStream(filePath), new File(SettingConstants.REPOSITORY_LOCATION + File.separator + filePath));
                }
                continue;
            }

            NodeList children = item.getChildNodes();
            if (children.getLength() == 0) {
                continue;
            }
            String newPath = path.isEmpty() ? item.getNodeName() : path + "/" + item.getNodeName();
            processNodeList(children, newPath);
        }
    }
    
    public Properties getProperties() {
        return properties;
    }

}
