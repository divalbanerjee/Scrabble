/**
 * Created by div on 10/21/2016.
 */
public class temp {

    /*
    These are just notes:
     #ifndef _PLAYER_H
#define _PLAYER_H

#include <string>
#include <stdlib.h>
#include <time.h>
#include "hand.h"
using namespace std;

class player
{
public:
	player();
	player(string n, int s, hand h);

	string getn();
	int gets();
	hand geth();
	void setn(string n);
	void sets(int s);
	void seth(hand h);
	string handstring();
private:
	string myn;
	int mys;
	hand myh;
};

player::player()
{
	for (int i = 0;i < 7;i++) {
		myh.gett(i).getl() = "";
	}
	myn = "";
	mys = 0;
}

player::player(string n, int s, hand h)
{
	myn = n;
	mys = s;
	myh = h;
}

string player::getn()
{
	return myn;
}

int player::gets()
{
	return mys;
}

hand player::geth()
{
	return myh;
}

void player::setn(string n)
{
	myn = n;
}

void player::sets(int s)
{
	mys = s;
}

void player::seth(hand h)
{
	myh = h;
}

string player::handstring()
{
	string output;
	for (int i = 0;i < 7;i++) {
		output = output + myh.gett(i).getl() + " ";
	}
	return output;
}
#endif

#ifndef _SCRABBLE_H
#define _SCRABBLE_H

#include <string>
#include <stdlib.h>
#include <time.h>
#include <sstream>
#include <fstream>
#include "bagoftiles.h"
#include "randgen.h"
#include "player.h"
using namespace std;

class scrabble
{
public:
	void getwords();
	void grabtiles(player &p, bagoftiles &b);
	void replace(player &p, bagoftiles &b, int &n);
	void scoreword(player &p, bagoftiles &b, string &w);
	int checkhand(player &p, string &w);
	int checkword(string &w);
private:
	string *myw = new string[80000];
	int mynw;
};

void scrabble::getwords()
{
	string line;
	ifstream myfile("words.txt");
	int i = 0;
	if (myfile.is_open())
	{
		while (getline(myfile, line))
		{
			myw[i] = line;
			i++;
		}
		myfile.close();
	}
	mynw = i;
}

void scrabble::grabtiles(player &p, bagoftiles &b)
{
	RandGen r;
	hand h;
	for (int i = 0;i < 7;i++) {
		h.sett(i, b.gett(r.RandInt(100)));
	}
	p.seth(h);
}

void scrabble::replace(player &p, bagoftiles &b, int &n)
{
	tile blank("", 0);
	RandGen r;
	hand h;
	h = p.geth();
	int i = 0;
	while(i < 7) {
		if (p.geth().gett(i).getl() == "") {
			int j = r.RandInt(100);
			if (b.gett(j).getl() != "") {
				h.sett(i, b.gett(j));
				b.sett(j, blank);
				i++;
			}
		}
		else {
			i++;
		}
	}
	p.seth(h);
}

void scrabble::scoreword(player &p, bagoftiles &b, string &w)
{
	tile blank("", 0);
	hand h(p.geth());
	for (int i = 0;i <= w.length();i++) {
		stringstream ss;
		string let;
		ss << w[i];
		ss >> let;
		for (int j = 0;j < 7;j++) {
			string leth = p.geth().gett(j).getl();
			if (let == leth) {
				p.sets(p.gets() + p.geth().gett(j).getv());
				h.sett(j, blank);
				p.seth(h);
				break;
			}
		}
	}
}

int scrabble::checkhand(player &p, string &w)
{
	int check = 1;
	int flag = 0;
	for (int i = 0;i < w.length();i++) {
		stringstream ss;
		string let;
		ss << w[i];
		ss >> let;
		for (int j = 0;j < 7;j++) {
			string hlet = p.geth().gett(j).getl();
			if (let == hlet) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			check = 0;
			break;
		}
		flag = 0;
	}
	return check;
}

int scrabble::checkword(string &w)
{
	int exist = 0;
	for (int i = 0;i < mynw;i++) {
		if (w == myw[i]) {
			exist = 1;
			break;
		}
	}
	return exist;
}
#endif


    #ifndef _HAND_H
#define _HAND_H

#include <stdlib.h>
#include <time.h>
#include <string>
#include "tile.h"
using namespace std;

class hand
{
public:
	hand();
	hand(const hand &);
	tile gett(int t);
	void sett(int &n, tile &t);
private:
	tile myt[7];
};

hand::hand()
{
	for (int i = 0;i < 7;i++) {
		myt[i].getl() = "";
	}
}

hand::hand(const hand & h)
{
	for (int i = 0;i < 7;i++) {
		myt[i] = h.myt[i];
	}
}

tile hand::gett(int t)
{
	return myt[t];
}

void hand::sett(int &n, tile &t)
{
	myt[n] = t;
}
#endif


#ifndef _TOPTEN_H
#define _TOPTEN_H

#include <fstream>
#include <string>
#include <algorithm>
#include <sstream>
#include "player.h"
using namespace std;

class topten
{
public:
	topten();
	topten(const topten &);
	void geths();
	bool checkscore(player &p);
	void savescores();
	string tostring(int n);
private:
	player myp[10];
};

topten::topten()
{
	for (int i = 0;i < 10;i++) {
		myp[i].setn("");
		myp[i].sets(0);
	}
}

topten::topten(const topten & obj)
{

}

void topten::geths()
{

	string line;
	string sscore;
	int i = 1;
	int n = 0;
	ifstream myfile("topten.txt");
	if (myfile.is_open())
	{
		while (getline(myfile, line))
		{
			if (i % 2 != 0) {
				myp[n].setn(line);
			}
			else {
				sscore = line;
				int score;
				istringstream buffer(sscore);
				buffer >> score;
				myp[n].sets(score);
				n++;
			}
			i++;
		}
		myfile.close();
	}
}

bool topten::checkscore(player &p)
{
	bool nhscore = false;
	if (p.gets() > myp[9].gets()) {
		myp[9] = p;
		nhscore = true;
		player temp;
		for (int i = 0; i < 9; i++){
			for (int j = (i + 1); j < 10; j++){
				if (myp[i].gets() < myp[j].gets()){
					temp = myp[i];
					myp[i] = myp[j];
					myp[j] = temp;
				}
			}
		}
	}
	return nhscore;
}

void topten::savescores()
{
	ofstream myfile("topten.txt");
	if (myfile.is_open())
	{
		int i = 0;
		while (i <= 9) {
			myfile << myp[i].getn() << endl;
			myfile << myp[i].gets() << endl;
			i++;
		}
		myfile.close();
	}
}

string topten::tostring(int n)
{
	string output;
	ostringstream b1;
	b1 << myp[n].gets();
	output = myp[n].getn() + '\t' + b1.str();
	return output;
}
#endif

     */
}


