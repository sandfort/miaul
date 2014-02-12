package us.jsand.miaul;

import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.util.Marshalling;

class MusicXMLReader extends MiaulReader {
    public ScorePartwise read(InputStream in) throws MiaulReaderException{
        try {
            return Marshalling.unmarshal(in);
        } catch (JAXBException jaxbe) {
            throw new MiaulReaderException("The XML unmarshalling failed.", 
                    jaxbe);
        } catch (SAXException saxe) {
            throw new MiaulReaderException("The XML parsing failed.", saxe);
        } catch (ParserConfigurationException pce) {
            throw new MiaulReaderException("There was a configuration problem.",
                    pce);
        } finally {
            in.close();
        }
    }
}

