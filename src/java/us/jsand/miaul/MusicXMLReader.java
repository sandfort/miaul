package us.jsand.miaul;

import java.io.InputStream;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.audiveris.proxymusic.ScorePartwise;
import com.audiveris.proxymusic.util.Marshalling;

class MusicXMLReader {
    public ScorePartwise read(InputStream in) {
        try {
            return Marshalling.unmarshal(in);
        } catch (JAXBException jaxbe) {
            return null;
        } catch (SAXException saxe) {
            return null;
        } catch (ParserConfigurationException pce) {
            return null;
        }
    }
}

