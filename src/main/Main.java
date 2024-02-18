package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	
	ArrayList<String> kodeKaryawanList = new ArrayList<>();
	ArrayList<String> namaKaryawanList = new ArrayList<>();
	ArrayList<String> jenisKelaminList = new ArrayList<>();
	ArrayList<String> jabatanList = new ArrayList<>();
	ArrayList<Integer> gajiKaryawanList = new ArrayList<>();
	
	public Main() {
		int choice;
		do {
			System.out.println("PT ChipiChapa");
			System.out.println("-----------------------");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.println("5. Exit");
			choice = scan.nextInt();
			scan.nextLine();
			
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				view();
				System.out.println("ENTER to return");
				scan.nextLine();
				break;
			case 3:
				view();
				update();
				break;
			case 4:
				view();
				delete();
				break;
			case 5:
				System.out.print("EXIT Successfully!");
				break;
			}
		} while (choice < 5 && choice > 0);
	}
	
	int manager = 0, supervisor = 0, admin = 0, gajiUpdated, newGaji;
	String jabatan;
	void insert() {
		String namaKaryawan;
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			namaKaryawan = scan.nextLine();
		} while (namaKaryawan.length() < 3);
		
		String jenisKelamin;
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenisKelamin = scan.nextLine();
		} while (!(jenisKelamin.equals("Laki-laki") || jenisKelamin.equals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		char random1, random2;
		random1 = (char) (random.nextInt(26) + 'A');
		random2 = (char) (random.nextInt(26) + 'A');
		int randomNumber = random.nextInt(10000);
		String randomNum = String.format("%04d", randomNumber);
		String rand = " " + random1 + random2 + "-" + randomNum;
		System.out.println("Berhasil menambahkan karyawan dengan id" + rand);
		if(!kodeKaryawanList.contains(rand)) {
			kodeKaryawanList.add(rand);
		}
		namaKaryawanList.add(namaKaryawan);
		jenisKelaminList.add(jenisKelamin);
		jabatanList.add(jabatan);
		
		if (jabatan.equals("Manager")){
			gajiManager();
		} else if (jabatan.equals("Supervisor")) {
			gajiSupervisor();
		} else {
			gajiAdmin();
		}
		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	void gajiManager() {
		gajiKaryawanList.add(8000000);
		manager++;
		if ((manager - 1) % 3 == 0 && manager != 1) {
			System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
			gajiUpdated = 0;
			for (int i = 0; i < jabatanList.size(); i++) {
				if (jabatanList.get(i).equals(jabatan)) {
					newGaji = gajiKaryawanList.get(i) + (int) (gajiKaryawanList.get(i) * 0.10);
					gajiKaryawanList.set(i, newGaji);
					gajiUpdated++;
					if (gajiUpdated == manager - 1){
						System.out.println(kodeKaryawanList.get(i));
						break;
					} else {
						System.out.print(kodeKaryawanList.get(i) + ",");
					}
				}
			}
		}
	}
	
	void gajiSupervisor() {
		gajiKaryawanList.add(6000000);
		supervisor++;
		if ((supervisor - 1) % 3 == 0 && supervisor != 1) {
			System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
			gajiUpdated = 0;
			for (int i = 0; i < jabatanList.size(); i++) {
				if (jabatanList.get(i).equals(jabatan)) {
					newGaji = gajiKaryawanList.get(i) + (int) (gajiKaryawanList.get(i) * 0.075);
					gajiKaryawanList.set(i, newGaji);
					gajiUpdated++;
					if (gajiUpdated == supervisor - 1){
						System.out.println(kodeKaryawanList.get(i));
						break;
					} else {
						System.out.print(kodeKaryawanList.get(i) + ",");
					}
				}
			}
		}
	}
	
	void gajiAdmin() {
		gajiKaryawanList.add(4000000);
		admin++;
		if ((admin - 1) % 3 == 0 && admin != 1) {
			System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
			gajiUpdated = 0;
			for (int i = 0; i < jabatanList.size(); i++) {
				if (jabatanList.get(i).equals(jabatan)) {
					newGaji = gajiKaryawanList.get(i) + (int) (gajiKaryawanList.get(i) * 0.05);
					gajiKaryawanList.set(i, newGaji);
					gajiUpdated++;
					if (gajiUpdated == admin - 1){
						System.out.println(kodeKaryawanList.get(i));
						break;
					} else {
						System.out.print(kodeKaryawanList.get(i) + ",");
					}
				}
			}
		}
	}
	
	void sorting() {
		String temp;
		int tempNum;
		for (int i = 0; i < jabatanList.size(); i++) {
			for (int j = i; j < jabatanList.size(); j++) {
				if (namaKaryawanList.get(i).compareTo(namaKaryawanList.get(j)) > 0) {
					temp = namaKaryawanList.get(i);
                    namaKaryawanList.set(i, namaKaryawanList.get(j));
                    namaKaryawanList.set(j, temp);
                    temp = kodeKaryawanList.get(i);
                    kodeKaryawanList.set(i, kodeKaryawanList.get(j));
                    kodeKaryawanList.set(j, temp);
                    temp = jenisKelaminList.get(i);
                    jenisKelaminList.set(i, jenisKelaminList.get(j));
                    jenisKelaminList.set(j, temp);
                    temp = jabatanList.get(i);
                    jabatanList.set(i, jabatanList.get(j));
                    jabatanList.set(j, temp);
                    tempNum = gajiKaryawanList.get(i);
                    gajiKaryawanList.set(i, gajiKaryawanList.get(j));
                    gajiKaryawanList.set(j, tempNum);
				}
			}
		}
	}
	
	void view() {
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
		sorting();
		for (int i = 0; i < jabatanList.size(); i++) {
			System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13s|\n", i + 1, kodeKaryawanList.get(i), namaKaryawanList.get(i), jenisKelaminList.get(i), jabatanList.get(i), gajiKaryawanList.get(i));
		}
		System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
	}
	
	int updateNum;
	String jabatanBaru;
	void update() {
		if (kodeKaryawanList.size() == 0) {
			System.out.println("There's no data that can be updated. ENTER to return");
			scan.nextLine();
			return;
		}
		do {
			System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
			updateNum = scan.nextInt();
			scan.nextLine();
		} while (updateNum < 1 || updateNum > kodeKaryawanList.size());
		
		String namaKaryawanBaru;
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			namaKaryawanBaru = scan.nextLine();
		} while (namaKaryawanBaru.length() < 3 && !namaKaryawanBaru.equals("0"));
		if (!namaKaryawanBaru.equals("0")) {
			namaKaryawanList.set(updateNum - 1, namaKaryawanBaru);
		}

		String jenisKelaminBaru;
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jenisKelaminBaru = scan.nextLine();
		} while (!(jenisKelaminBaru.equals("Laki-laki") || jenisKelaminBaru.equals("Perempuan") || jenisKelaminBaru.equals("0")));
		if (!jenisKelaminBaru.equals("0")) {
			jenisKelaminList.set(updateNum - 1, jenisKelaminBaru);
		}
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatanBaru = scan.nextLine();
		} while (!(jabatanBaru.equals("Manager") || jabatanBaru.equals("Supervisor") || jabatanBaru.equals("Admin") || jabatanBaru.equals("0")));
		
		System.out.println("Berhasil mengupdate karyawan dengan id" + kodeKaryawanList.get(updateNum - 1));
		if (jabatanList.get(updateNum - 1).equals("Manager") && !jabatanBaru.equals("Manager") && !jabatanBaru.equals("0")) {
			manager--;
			moveArrayList();
			if (jabatanBaru.equals("Supervisor")) {
				gajiSupervisor();
			} else {
				gajiAdmin();
			}
		} else if (jabatanList.get(updateNum - 1).equals("Supervisor") && !jabatanBaru.equals("Supervisor") && !jabatanBaru.equals("0")) {
			supervisor--;
			moveArrayList();
			if (jabatanBaru.equals("Manager")){
				gajiManager();
			} else {
				gajiAdmin();
			}
		} else if (jabatanList.get(updateNum - 1).equals("Admin") && !jabatanBaru.equals("Admin") && !jabatanBaru.equals("0")) {
			admin--;
			moveArrayList();
			if (jabatanBaru.equals("Manager")){
				gajiManager();
			} else if (jabatanBaru.equals("Supervisor")) {
				gajiSupervisor();
			}
		}

		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	void moveArrayList() {
		String moveKode = kodeKaryawanList.get(updateNum - 1);
		kodeKaryawanList.remove(updateNum - 1);
		kodeKaryawanList.add(moveKode);
		
		String moveNama = namaKaryawanList.get(updateNum - 1);
		namaKaryawanList.remove(updateNum - 1);
		namaKaryawanList.add(moveNama);
		
		String moveJk = jenisKelaminList.get(updateNum - 1);
		jenisKelaminList.remove(updateNum - 1);
		jenisKelaminList.add(moveJk);
		
		jabatanList.remove(updateNum - 1);
		jabatanList.add(jabatanBaru);
		jabatan = jabatanBaru;
		
		gajiKaryawanList.remove(updateNum - 1);
	}
	
	void delete() {
		int deleteNum;
		if (kodeKaryawanList.size() == 0) {
			System.out.println("There's no data that can be deleted. ENTER to return");
			scan.nextLine();
			return;
		}
		do {
			System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
			deleteNum = scan.nextInt();
			scan.nextLine();
		} while (deleteNum < 1 || deleteNum > kodeKaryawanList.size());
		
		System.out.println("Karyawan dengan kode" + kodeKaryawanList.get(deleteNum - 1) + " berhasil dihapus");
		kodeKaryawanList.remove(deleteNum - 1);
		namaKaryawanList.remove(deleteNum - 1);
		jenisKelaminList.remove(deleteNum - 1);
		if (jabatanList.get(deleteNum - 1).equals("Manager")) {
			manager--;
		} else if (jabatanList.get(deleteNum - 1).equals("Supervisor")) {
			supervisor--;
		} else if (jabatanList.get(deleteNum - 1).equals("Admin")) {
			admin--;
		}
		jabatanList.remove(deleteNum - 1);
		gajiKaryawanList.remove(deleteNum - 1);
		System.out.println("ENTER to return");
		scan.nextLine();
	}

	public static void main(String[] args) {
		new Main();
	}

}
