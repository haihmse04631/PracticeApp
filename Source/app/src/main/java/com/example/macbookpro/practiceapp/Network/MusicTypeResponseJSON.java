package com.example.macbookpro.practiceapp.Network;

import java.util.List;

/**
 * Created by MacbookPro on 3/26/18.
 */

public class MusicTypeResponseJSON {
    public List<MusicTypeJSON> subgenres;

    public class MusicTypeJSON {
        private String id;
        private String translation_key;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTranslation_key() {
            return translation_key;
        }

        public void setTranslation_key(String translation_key) {
            this.translation_key = translation_key;
        }
    }
}
