/*
*   Copyright 2022. Eduardo Programador
*   www.eduardoprogramador.com
*   consultoria@eduardoprogramador.com
*
*   Todos os direitos reservados.
* */

import com.eduardoprogramador.common.EngineFailHandler;
import com.eduardoprogramador.common.InOut;
import com.eduardoprogramador.dujava.Utilities;
import java.util.ArrayList;

public class DataAnalysis {

    private static int count = 0;
    static boolean fillYear = false;
    static boolean fillMonth = false;
    static boolean fillRegion = false;
    static boolean fillProvince = false;
    static boolean fillFuelType = false;
    static boolean fillPrice = false;

    public static void main(String[] args) {


        ArrayList<String> years = new ArrayList<>();
        ArrayList<String> months = new ArrayList<>();
        ArrayList<String> regions = new ArrayList<>();
        ArrayList<String> provinces = new ArrayList<>();
        ArrayList<String> fuelTypes = new ArrayList<>();
        ArrayList<String> prices = new ArrayList<>();

        ArrayList<String> pureYears = new ArrayList<>();
        ArrayList<String> pureMonths = new ArrayList<>();
        ArrayList<String> pureRegions = new ArrayList<>();
        ArrayList<String> pureProvinces = new ArrayList<>();
        ArrayList<String> pureFuelTypes = new ArrayList<>();
        ArrayList<String> purePrices = new ArrayList<>();

        Utilities utilities = new Utilities();



        String filePath = "vendas_petroleo.csv";

        utilities.print("### Análise de Dados Estatísticos - BigData e Machine Learning ###\n");
        utilities.print("Tema: Estatísticas de Vendas e Petróleo e Biocombustíveis");
        utilities.print("Fonte dos Dados: (X) Público\t( ) Particular");
        utilities.print("Analista de Dados / Programador: Eduardo Programador");
        utilities.print("Contato do Analista: consultoria@eduardoprogramador.com | (81) 98860-0704");
        utilities.print("Ferramenta Utilizada: Tecnologia Própria. Algoritmo Construído em Java. Copyright 2022. Todos os Direitos Reservados");
        utilities.print("Fonte dos Dados: " + "http://landpage-h.cgu.gov.br/dadosabertos/index.php?url=https://www.gov.br/anp/pt-br/centrais-de-conteudo/dados-abertos/arquivos/vdpb/vendas-derivados-petroleo-e-etanol/vendas-derivados-petroleo-etanol-m3-1990-2021.csv");

        utilities.print("\n[*] Algoritmo em Andamento..\n[*] Aguarde (Pode demorar alguns minutos)...");

        try {
            InOut inOut = new InOut();
            inOut.readFromPath(filePath, new InOut.Parser() {
                @Override
                public void contentsOfFile(String line) {
                    String[] brute = line.split(";");

                    String year = brute[0];
                    String month = brute[1];
                    String region = brute[2];
                    String province = brute[3];
                    String fuelType = brute[4];
                    String price = brute[5];

                    years.add(year);
                    months.add(month);
                    regions.add(region);
                    provinces.add(province);
                    fuelTypes.add(fuelType);
                    prices.add(price);

                    if(count == 1) {
                        pureYears.add(year);
                        pureMonths.add(month);
                        pureRegions.add(region);
                        pureProvinces.add(province);
                        pureFuelTypes.add(fuelType);
                        purePrices.add(price);

                        count = 2;


                    }

                    if(count == 0)
                        count++;

                    if(count > 0 ) {
                        for (int i = 0; i < pureYears.size(); i++) {

                            if (year.equalsIgnoreCase(pureYears.get(i))) {
                                fillYear = false;
                            }
                        }

                        for (int i = 0; i < pureMonths.size(); i++) {
                            if(month.equalsIgnoreCase(pureMonths.get(i))) {
                                fillMonth = false;
                            }
                        }

                        for (int i = 0; i < pureRegions.size(); i++) {
                            if(region.equalsIgnoreCase(pureRegions.get(i))) {
                                fillRegion = false;
                            }
                        }


                        for (int i = 0; i < pureProvinces.size(); i++) {
                            if(province.equalsIgnoreCase(pureProvinces.get(i))) {
                                fillProvince = false;
                            }
                        }

                        for (int i = 0; i < pureFuelTypes.size(); i++) {
                            if(fuelType.equalsIgnoreCase(pureFuelTypes.get(i))) {
                                fillFuelType = false;
                            }
                        }

                        for (int i = 0; i < purePrices.size(); i++) {
                            if(price.equalsIgnoreCase(purePrices.get(i))) {
                                fillPrice = false;
                            }
                        }

                        if(fillYear)
                            pureYears.add(year);

                        if(fillMonth)
                            pureMonths.add(month);

                        if(fillRegion)
                            pureRegions.add(region);

                        if(fillProvince)
                            pureProvinces.add(province);

                        if(fillFuelType)
                            pureFuelTypes.add(fuelType);

                        if(fillPrice)
                            purePrices.add(price);

                        fillYear = true;
                        fillMonth = true;
                        fillRegion = true;
                        fillProvince = true;
                        fillFuelType = true;
                        fillPrice = true;
                    }
                }
            });
        } catch (EngineFailHandler handler) {
            handler.printStackTrace();
        } finally {
            utilities.print("\n[*] Resumo dos Dados:\n");
            utilities.print("Total de Registros: " + years.size());
            utilities.print("Anos: " + pureYears.size());
            utilities.print("Meses: " + pureMonths.size());
            utilities.print("Regiões: " + pureRegions.size());
            utilities.print("Estados: " + pureProvinces.size());
            utilities.print("Combustíveis: " + pureFuelTypes.size());
            utilities.print("Preços: " + purePrices.size());

            utilities.print("\n### Estatísticas de Estudo ###\n\n");
            utilities.print("1. Anos");
            utilities.print(pureYears.toString());
            utilities.print("2. Meses");
            utilities.print(pureMonths.toString());
            utilities.print("3. Regiões");
            utilities.print(pureRegions.toString());
            utilities.print("4. Estados");
            utilities.print(pureProvinces.toString());
            utilities.print("5. Combustíveis");
            utilities.print(pureFuelTypes.toString());
            utilities.print("\nAnálise de Dados\n");

            utilities.print("[*] Calculando, Aguarde...");

            float price01 = 0; float price02 = 0; float price03 = 0; float price04 = 0; float price05 = 0;
            float price06 = 0; float price07 = 0; float price08 = 0;

            float count01 = 0; float count02 = 0; float count03 = 0; float count04 = 0; float count05 = 0;

            float _2019Etanol = 0; float _2020Etanol = 0; float _2021Etanol = 0;
            float _2019GasolinaC = 0; float _2020GasolinaC = 0; float _2021GasolinaC = 0;
            float _2019GasolinaAviacao = 0; float _2020GasolinaAviacao = 0; float _2021GasolinaAviacao = 0;
            float _2019Glp = 0; float _2020Glp = 0; float _2021Glp = 0;
            float _2019QueroseneAviacao = 0; float _2020QueroseneAviacao = 0; float _2021QueroseneAviacao = 0;
            float _2019QueroseneIluminante = 0; float _2020QueroseneIluminante = 0; float _2021QueroseneIluminante = 0;
            float _2019OleoCombustivel = 0; float _2020OleoCombustivel = 0; float _2021OleoCombustivel = 0;
            float _2019OleoDiesel = 0; float _2020OleoDiesel = 0; float _2021OleoDiesel = 0;

            for (int i = 0; i < fuelTypes.size(); i++) {
                if(regions.get(i).equalsIgnoreCase("REGIÃO NORTE")) {
                    count01 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(regions.get(i).equalsIgnoreCase("REGIÃO NORDESTE")) {
                    count02 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(regions.get(i).equalsIgnoreCase("REGIÃO SUDESTE")) {
                    count03 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(regions.get(i).equalsIgnoreCase("REGIÃO SUL")) {
                    count04 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(regions.get(i).equalsIgnoreCase("REGIÃO CENTRO-OESTE")) {
                    count05 += Float.valueOf(prices.get(i).replaceAll(",","."));
                }

                if(fuelTypes.get(i).equalsIgnoreCase("ETANOL HIDRATADO")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019Etanol += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020Etanol += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021Etanol += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price01 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(fuelTypes.get(i).equalsIgnoreCase("GASOLINA C")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019GasolinaC += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020GasolinaC += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021GasolinaC += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price02 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(fuelTypes.get(i).equalsIgnoreCase("GASOLINA DE AVIAÇÃO")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019GasolinaAviacao += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020GasolinaAviacao += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021GasolinaAviacao += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price03 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(fuelTypes.get(i).equalsIgnoreCase("GLP")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019Glp += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020Glp += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021Glp += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price04 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(fuelTypes.get(i).equalsIgnoreCase("QUEROSENE DE AVIAÇÃO")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019QueroseneAviacao += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020QueroseneAviacao += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021QueroseneAviacao += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price05 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(fuelTypes.get(i).equalsIgnoreCase("QUEROSENE ILUMINANTE")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019QueroseneIluminante += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020QueroseneIluminante += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021QueroseneIluminante += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price06 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(fuelTypes.get(i).equalsIgnoreCase("ÓLEO COMBUSTÍVEL")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019OleoCombustivel += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020OleoCombustivel += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021OleoCombustivel += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price07 += Float.valueOf(prices.get(i).replaceAll(",","."));
                } else if(fuelTypes.get(i).equalsIgnoreCase("ÓLEO DIESEL")) {
                    if(years.get(i).equalsIgnoreCase("2019")) {
                        _2019OleoDiesel += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2020")) {
                        _2020OleoDiesel += Float.valueOf(prices.get(i).replaceAll(",","."));
                    } else if(years.get(i).equalsIgnoreCase("2021")) {
                        _2021OleoDiesel += Float.valueOf(prices.get(i).replaceAll(",","."));
                    }
                    price08 += Float.valueOf(prices.get(i).replaceAll(",","."));
                }
            }

            utilities.print("1. Valor de Vendas por tipo de combustível\n");

            utilities.print("Etanol Hidratado: " + price01);
            utilities.print("Gasolina C: " + price02);
            utilities.print("Gasolina de Aviação: " + price03);
            utilities.print("GLP: " + price04);
            utilities.print("Querosene de Aviação: " + price05);
            utilities.print("Querosene Iluminante: " + price06);
            utilities.print("Óleo Combustível: " + price07);
            utilities.print("Óleo Diesel: " + price08);

            utilities.print("\n2. Valor de Vendas por região\n");

            utilities.print("Norte: " + count01);
            utilities.print("Nordeste: " + count02);
            utilities.print("Sudeste: " + count03);
            utilities.print("Sul: " + count04);
            utilities.print("Centro-Oeste: " + count05);

            utilities.print("\n3. Vendas por Tipo de Combustível, 2019, 2020 e 2021\n");

            utilities.print("\n[*] 3.1. Etanol Hidratado [*]\n");
            utilities.print("2019: " + _2019Etanol);
            utilities.print("2020: " + _2020Etanol);
            utilities.print("2021: " + _2021Etanol);

            utilities.print("\n[*] 3.2. Gasolina C [*]\n");
            utilities.print("2019: " + _2019GasolinaC);
            utilities.print("2020: " + _2020GasolinaC);
            utilities.print("2021: " + _2021GasolinaC);

            utilities.print("\n[*] 3.3. Gasolina de Aviação [*]\n");
            utilities.print("2019: " +_2019GasolinaAviacao);
            utilities.print("2020: " + _2020GasolinaAviacao);
            utilities.print("2021: " + _2021GasolinaAviacao);

            utilities.print("\n[*] 3.4. GLP [*]\n");
            utilities.print("2019: " + _2019Glp);
            utilities.print("2020: " + _2020Glp);
            utilities.print("2021: " + _2021Glp);

            utilities.print("\n[*] 3.5. Querosene de Aviação [*]\n");
            utilities.print("2019: " + _2019QueroseneAviacao);
            utilities.print("2020: " + _2020QueroseneAviacao);
            utilities.print("2021: " + _2021QueroseneAviacao);

            utilities.print("\n[*] 3.6. Querosene Iluminante [*]\n");
            utilities.print("2019: " + _2019QueroseneIluminante);
            utilities.print("2020: " + _2020QueroseneIluminante);
            utilities.print("2021: " + _2021QueroseneIluminante);

            utilities.print("\n[*] 3.7. Óleo Combustível [*]\n");
            utilities.print("2019: " + _2019OleoCombustivel);
            utilities.print("2020: " + _2020OleoCombustivel);
            utilities.print("2021: " + _2021OleoCombustivel);

            utilities.print("\n[*] 3.8. Óleo Diesel [*]\n");
            utilities.print("2019: " + _2019OleoDiesel);
            utilities.print("2020: " + _2020OleoDiesel);
            utilities.print("2021: " + _2021OleoDiesel);

            utilities.print("\n\n### FIM ###\n\n");
            utilities.print("Copyright 2022. Eduardo Programador");
        }

    }
}
