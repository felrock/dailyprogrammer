/*
[2017 - 11 - 22] Challenge #341[Intermediate] Listening for Incoming Aircraft

You're the operator of a small squadron stationed along the coast listening for incoming enemy aircraft. 
This is before RADAR, and so your team is equipped with giant microphones and headphones that they use to constantly scour 
the skies for signs of incoming aircraft. All they are able to get to you is the angle and direction in which they heard a propeller.

Acoustic location is the science of using sound to determine the distance and direction of something. As a military air defense tool, 
passive acoustic location was used from mid-World War I to the early years of World War II to detect enemy aircraft by picking up the noise 
of their engines. Most of the work on anti-aircraft sound ranging was done by the British. They developed an extensive network of sound 
mirrors that were used from World War I through World War II. Sound mirrors normally work by using moveable microphones to find the angle 
that maximizes the amplitude of sound received, which is also the bearing angle to the target. Two sound mirrors at different positions will generate 
two different bearings, which allows the use of triangulation to determine a sound source's position.

Your task today is to be the operator of such a network - given locations of your operators and their reports, 
can you figure out where are the enemy aircraft? Hurry, you have to scramble the fighters to defend your nation.

Test input(x-cord, y-cord, angle):
	0 0 45.0
	10 0 0.0

Test output(x-cord, y-cord):
	10.0 10.0

*/
#include <iostream>
#include <vector>
#include <string>
#include <math.h>

# define M_PI           3.14159265

struct a_location 
{
	int x;
	int y;
	double angle;
};

struct line_eq 
{
	double k;
	double m;
	int x0;
	int y0;
};

struct point
{
	double x;
	double y;
};

line_eq get_line_eq_from_location(struct a_location pos)
{ 
	double radians = pos.angle * (M_PI / 180.0);
	double k = std::tan(radians);
	if (k > 10000000.0)
		k = 0;
	double m = pos.y - (k * pos.x);
	if (m > 10000000.0 || m < -10000000.0)
		m = 0;
	return line_eq{k,m,pos.x, pos.y};
}
point line_intersect_line( line_eq line1, line_eq line2)
{
	point p;
	// line1 is static and line2 varys
	if (line1.k == 0 && line2.k != 0)
	{
		if (line1.m == 0)
		{
			p.x = line1.x0;
			p.y = line2.k*line1.x0 + line2.m;
		}
		else
		{
			p.y = line1.m;
			p.x = (line1.m - line2.m) / line2.k;
		}
	}
	// line2 is static and line1 varys
	else if (line2.k == 0 && line1.k != 0)
	{
		if (line2.m == 0)
		{
			p.x = line2.x0;
			p.y = line1.k*line2.x0 + line1.m;
		}
		else
		{
			p.y = line2.m;
			p.x = (line2.m - line1.m) / line1.k;
		}
	}
	// both lines vary
	else
	{
		double delta_m = std::abs(line1.m - line2.m);
		double delta_k = std::abs(line1.k - line2.k);
		p.x = delta_m / delta_k;
		p.y = line1.k*p.x + line1.m;
	}
	return p;
}
a_location parse_input(std::string input)
{
	std::string t;
	int x = std::stoi(input.substr(0, input.find_first_of(" ")));
	input = input.substr(input.find_first_of(" ") + 1, input.size() - 1);
	int y = std::stoi(input.substr(0, input.find_first_of(" ")));
	input = input.substr(input.find_first_of(" ") + 1, input.size() - 1);
	double angle = std::stod(input);
	angle = 90.0 - angle;
	return a_location{x,y,angle};
}
int main() {
	std::string input1;
	std::string input2;
	std::getline(std::cin, input1);
	std::getline(std::cin, input2);
	a_location pos1 = parse_input(input1);
	a_location pos2 = parse_input(input2);
	line_eq line1 = get_line_eq_from_location(pos1);
	line_eq line2 = get_line_eq_from_location(pos2);
	point aircraft_location = line_intersect_line(line1, line2);
	std::cout << aircraft_location.x << " " << aircraft_location.y << std::endl;
	return 0;
}
