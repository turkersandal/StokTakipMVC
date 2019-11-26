package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelStokKarti {
	
	String  stokKodu;
	String  guncelStokKodu;
	String  stokAdi;
	Integer stokTipi;
	String  stokBirimi;
	String  barkod;
	Double  kdvTipi;
	String  aciklama;
	String  tarih;
	Connect con = new Connect();
	
	//--------------Getters--And---Setters----------
	public String getStokKodu() {return stokKodu;}
	public void setStokKodu(String stokKodu) {this.stokKodu = stokKodu;	}
	public String getGuncelStokKodu() {return guncelStokKodu;}
	public void setguncelStokKodu(String _guncelStokKodu) {this.guncelStokKodu = _guncelStokKodu;	}
	public String getStokAdi() {return stokAdi;}
	public void setStokAdi(String stokAdi) {this.stokAdi = stokAdi;}
	public Integer getStokTipi() {return stokTipi;}
	public void setStokTipi(Integer stokTipi) {this.stokTipi = stokTipi;}
	public String getStokBirimi() {return stokBirimi;}
	public void setStokBirimi(String stokBirimi) {this.stokBirimi = stokBirimi;}
	public String getBarkod() {return barkod;}
	public void setBarkod(String barkod) {this.barkod = barkod;}
	public Double getKdvTipi() {return kdvTipi;}
	public void setKdvTipi(Double kdvTipi) {this.kdvTipi = kdvTipi;}
	public String getAciklama() {return aciklama;}
	public void setAciklama(String aciklama) {this.aciklama = aciklama;}
	public String getTarih() {return tarih;}
	public void setTarih(String tarih) {this.tarih = tarih;}
		
	
	
	
	public void insert() {
		try {
		String query="insert into stok_card(stokKodu,stokAdi,stokTipi,birim,barkod,kdv,aciklama,tarih)"
				+ " values ('"+getStokKodu()+"','"+getStokAdi()+"','"+getStokTipi()+"','"+getStokBirimi()+"','"+getBarkod()+"','"+getKdvTipi()+
				"','"+getAciklama()+"','"+getTarih()+"')";
		con.send(query);
	}catch(Exception e) {}
		
	}
	
	public void delete() {
		try {
			String query ="DELETE FROM stok_card WHERE stokKodu='"+getStokKodu()+"'";
			con.send(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	public void update() {
		try {
			String query ="UPDATE stok_card SET stokKodu='"+getGuncelStokKodu()+"',stokAdi='"+getStokAdi()
					+ "',stokTipi='"+getStokTipi()+"',birim='"+getStokBirimi()+"',barkod='"+getBarkod()
					+"',kdv='"+getKdvTipi()+"', aciklama='"+getAciklama()+"', tarih='"+getTarih()+"' WHERE stokKodu='"+getStokKodu()+"'";
			con.send(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ModelStokKarti> search() {
		
		ArrayList<ModelStokKarti> cardList = new ArrayList<ModelStokKarti>();
		String query ="select * from stok_card where stokKodu = '"+getStokKodu()+"'";
		ResultSet rs = con.result(query);
		try {
				while(rs.next()) {
				ModelStokKarti card = new ModelStokKarti();
				card.setStokKodu(rs.getString("stokKodu"));
				card.setStokAdi(rs.getString("stokAdi"));
				card.setStokTipi(rs.getInt("stokTipi"));
				card.setStokBirimi(rs.getString("birim"));
				card.setBarkod(rs.getString("barkod"));
				card.setKdvTipi(rs.getDouble("kdv"));
				card.setAciklama(rs.getString("aciklama"));
				card.setTarih(rs.getString("tarih"));
				cardList.add(card);
				
				}
		} catch (SQLException e) {
		
			
		}
		return cardList;
		
	}

	public ArrayList<ModelStokKarti> list(){
		ArrayList<ModelStokKarti> cardList = new ArrayList<ModelStokKarti>();
		try {
			
			String query = "select * from stok_card";
			ResultSet rs = con.result(query);
				while(rs.next()) {
					
					ModelStokKarti card = new ModelStokKarti();
					card.setStokKodu(rs.getString("stokKodu"));
					card.setStokAdi(rs.getString("stokAdi"));
					card.setStokTipi(rs.getInt("stokTipi"));
					card.setStokBirimi(rs.getString("birim"));
					card.setBarkod(rs.getString("barkod"));
					card.setKdvTipi(rs.getDouble("kdv"));
					card.setAciklama(rs.getString("aciklama"));
					card.setTarih(rs.getString("tarih"));
					
					cardList.add(card);	
				
					
				}
				
			} catch (SQLException e) {
			e.printStackTrace();
	   }
		return cardList;
   }
	
	
	
}
