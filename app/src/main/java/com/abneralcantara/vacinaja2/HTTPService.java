package com.abneralcantara.vacinaja2;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, CEP> {

    private final String cep;

    public HTTPService(String cep) {
        this.cep = cep;
    }

    @Override
    protected CEP doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://viacep.com.br/ws/"+ this.cep + "/json/");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setConnectTimeout(5000);
            InputStream in = connection.getInputStream();
            connection.connect();

            Scanner scanner = scanner = new Scanner(in);

            while (scanner.hasNext()) {
                resposta.append(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(), CEP.class);
    }
}
