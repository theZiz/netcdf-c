import java.util.*;
import ucar.ma2.*;
import ucar.nc2.*;
import ucar.nc2.NetcdfFile.*;

public class Main
{

static public void main(String[] argv) throws Exception
{

    /* dimension lengths */
    final int Dr_len = 2;
    final int D1_len = 1;
    final int D2_len = 2;
    final int D3_len = 3;
    final int dim_MINUS_name_MINUS_dashes_len = 4;
    final int dim_PERIOD_name_PERIOD_dots_len = 5;
    final int dim_PLUS_name_PLUS_plusses_len = 6;
    final int dim_ATSIGN_name_ATSIGN_ats_len = 7;


    /* enter define mode */
    NetcdfFileWriteable ncfile = NetcdfFileWriteable.createNew("c0.nc", true);

    /* define dimensions */
    Dimension Dr_dim = ncfile.addDimension("Dr", Dr_len);
    Dimension D1_dim = ncfile.addDimension("D1", D1_len);
    Dimension D2_dim = ncfile.addDimension("D2", D2_len);
    Dimension D3_dim = ncfile.addDimension("D3", D3_len);
    Dimension dim_MINUS_name_MINUS_dashes_dim = ncfile.addDimension("dim-name-dashes", dim_MINUS_name_MINUS_dashes_len);
    Dimension dim_PERIOD_name_PERIOD_dots_dim = ncfile.addDimension("dim.name.dots", dim_PERIOD_name_PERIOD_dots_len);
    Dimension dim_PLUS_name_PLUS_plusses_dim = ncfile.addDimension("dim+name+plusses", dim_PLUS_name_PLUS_plusses_len);
    Dimension dim_ATSIGN_name_ATSIGN_ats_dim = ncfile.addDimension("dim@name@ats", dim_ATSIGN_name_ATSIGN_ats_len);

    /* define variables */

    ArrayList c_dimlist = new ArrayList();
    ncfile.addVariable("c", DataType.CHAR, c_dimlist);

    ArrayList b_dimlist = new ArrayList();
    ncfile.addVariable("b", DataType.BYTE, b_dimlist);

    ArrayList s_dimlist = new ArrayList();
    ncfile.addVariable("s", DataType.SHORT, s_dimlist);

    ArrayList i_dimlist = new ArrayList();
    ncfile.addVariable("i", DataType.INT, i_dimlist);

    ArrayList f_dimlist = new ArrayList();
    ncfile.addVariable("f", DataType.FLOAT, f_dimlist);

    ArrayList d_dimlist = new ArrayList();
    ncfile.addVariable("d", DataType.DOUBLE, d_dimlist);

    ArrayList cr_dimlist = new ArrayList();
    cr_dimlist.add(Dr_dim);
    ncfile.addVariable("cr", DataType.CHAR, cr_dimlist);

    ArrayList br_dimlist = new ArrayList();
    br_dimlist.add(Dr_dim);
    ncfile.addVariable("br", DataType.BYTE, br_dimlist);

    ArrayList sr_dimlist = new ArrayList();
    sr_dimlist.add(Dr_dim);
    ncfile.addVariable("sr", DataType.SHORT, sr_dimlist);

    ArrayList ir_dimlist = new ArrayList();
    ir_dimlist.add(Dr_dim);
    ncfile.addVariable("ir", DataType.INT, ir_dimlist);

    ArrayList fr_dimlist = new ArrayList();
    fr_dimlist.add(Dr_dim);
    ncfile.addVariable("fr", DataType.FLOAT, fr_dimlist);

    ArrayList dr_dimlist = new ArrayList();
    dr_dimlist.add(Dr_dim);
    ncfile.addVariable("dr", DataType.DOUBLE, dr_dimlist);

    ArrayList c1_dimlist = new ArrayList();
    c1_dimlist.add(D1_dim);
    ncfile.addVariable("c1", DataType.CHAR, c1_dimlist);

    ArrayList b1_dimlist = new ArrayList();
    b1_dimlist.add(D1_dim);
    ncfile.addVariable("b1", DataType.BYTE, b1_dimlist);

    ArrayList s1_dimlist = new ArrayList();
    s1_dimlist.add(D1_dim);
    ncfile.addVariable("s1", DataType.SHORT, s1_dimlist);

    ArrayList i1_dimlist = new ArrayList();
    i1_dimlist.add(D1_dim);
    ncfile.addVariable("i1", DataType.INT, i1_dimlist);

    ArrayList f1_dimlist = new ArrayList();
    f1_dimlist.add(D1_dim);
    ncfile.addVariable("f1", DataType.FLOAT, f1_dimlist);

    ArrayList d1_dimlist = new ArrayList();
    d1_dimlist.add(D1_dim);
    ncfile.addVariable("d1", DataType.DOUBLE, d1_dimlist);

    ArrayList c2_dimlist = new ArrayList();
    c2_dimlist.add(D2_dim);
    ncfile.addVariable("c2", DataType.CHAR, c2_dimlist);

    ArrayList b2_dimlist = new ArrayList();
    b2_dimlist.add(D2_dim);
    ncfile.addVariable("b2", DataType.BYTE, b2_dimlist);

    ArrayList s2_dimlist = new ArrayList();
    s2_dimlist.add(D2_dim);
    ncfile.addVariable("s2", DataType.SHORT, s2_dimlist);

    ArrayList i2_dimlist = new ArrayList();
    i2_dimlist.add(D2_dim);
    ncfile.addVariable("i2", DataType.INT, i2_dimlist);

    ArrayList f2_dimlist = new ArrayList();
    f2_dimlist.add(D2_dim);
    ncfile.addVariable("f2", DataType.FLOAT, f2_dimlist);

    ArrayList d2_dimlist = new ArrayList();
    d2_dimlist.add(D2_dim);
    ncfile.addVariable("d2", DataType.DOUBLE, d2_dimlist);

    ArrayList c3_dimlist = new ArrayList();
    c3_dimlist.add(D3_dim);
    ncfile.addVariable("c3", DataType.CHAR, c3_dimlist);

    ArrayList b3_dimlist = new ArrayList();
    b3_dimlist.add(D3_dim);
    ncfile.addVariable("b3", DataType.BYTE, b3_dimlist);

    ArrayList s3_dimlist = new ArrayList();
    s3_dimlist.add(D3_dim);
    ncfile.addVariable("s3", DataType.SHORT, s3_dimlist);

    ArrayList i3_dimlist = new ArrayList();
    i3_dimlist.add(D3_dim);
    ncfile.addVariable("i3", DataType.INT, i3_dimlist);

    ArrayList f3_dimlist = new ArrayList();
    f3_dimlist.add(D3_dim);
    ncfile.addVariable("f3", DataType.FLOAT, f3_dimlist);

    ArrayList d3_dimlist = new ArrayList();
    d3_dimlist.add(D3_dim);
    ncfile.addVariable("d3", DataType.DOUBLE, d3_dimlist);

    ArrayList cr1_dimlist = new ArrayList();
    cr1_dimlist.add(Dr_dim);
    cr1_dimlist.add(D1_dim);
    ncfile.addVariable("cr1", DataType.CHAR, cr1_dimlist);

    ArrayList br2_dimlist = new ArrayList();
    br2_dimlist.add(Dr_dim);
    br2_dimlist.add(D2_dim);
    ncfile.addVariable("br2", DataType.BYTE, br2_dimlist);

    ArrayList sr3_dimlist = new ArrayList();
    sr3_dimlist.add(Dr_dim);
    sr3_dimlist.add(D3_dim);
    ncfile.addVariable("sr3", DataType.SHORT, sr3_dimlist);

    ArrayList f11_dimlist = new ArrayList();
    f11_dimlist.add(D1_dim);
    f11_dimlist.add(D1_dim);
    ncfile.addVariable("f11", DataType.FLOAT, f11_dimlist);

    ArrayList d12_dimlist = new ArrayList();
    d12_dimlist.add(D1_dim);
    d12_dimlist.add(D2_dim);
    ncfile.addVariable("d12", DataType.DOUBLE, d12_dimlist);

    ArrayList c13_dimlist = new ArrayList();
    c13_dimlist.add(D1_dim);
    c13_dimlist.add(D3_dim);
    ncfile.addVariable("c13", DataType.CHAR, c13_dimlist);

    ArrayList s21_dimlist = new ArrayList();
    s21_dimlist.add(D2_dim);
    s21_dimlist.add(D1_dim);
    ncfile.addVariable("s21", DataType.SHORT, s21_dimlist);

    ArrayList i22_dimlist = new ArrayList();
    i22_dimlist.add(D2_dim);
    i22_dimlist.add(D2_dim);
    ncfile.addVariable("i22", DataType.INT, i22_dimlist);

    ArrayList f23_dimlist = new ArrayList();
    f23_dimlist.add(D2_dim);
    f23_dimlist.add(D3_dim);
    ncfile.addVariable("f23", DataType.FLOAT, f23_dimlist);

    ArrayList c31_dimlist = new ArrayList();
    c31_dimlist.add(D3_dim);
    c31_dimlist.add(D1_dim);
    ncfile.addVariable("c31", DataType.CHAR, c31_dimlist);

    ArrayList b32_dimlist = new ArrayList();
    b32_dimlist.add(D3_dim);
    b32_dimlist.add(D2_dim);
    ncfile.addVariable("b32", DataType.BYTE, b32_dimlist);

    ArrayList s33_dimlist = new ArrayList();
    s33_dimlist.add(D3_dim);
    s33_dimlist.add(D3_dim);
    ncfile.addVariable("s33", DataType.SHORT, s33_dimlist);

    ArrayList sr11_dimlist = new ArrayList();
    sr11_dimlist.add(Dr_dim);
    sr11_dimlist.add(D1_dim);
    sr11_dimlist.add(D1_dim);
    ncfile.addVariable("sr11", DataType.SHORT, sr11_dimlist);

    ArrayList ir12_dimlist = new ArrayList();
    ir12_dimlist.add(Dr_dim);
    ir12_dimlist.add(D1_dim);
    ir12_dimlist.add(D2_dim);
    ncfile.addVariable("ir12", DataType.INT, ir12_dimlist);

    ArrayList fr13_dimlist = new ArrayList();
    fr13_dimlist.add(Dr_dim);
    fr13_dimlist.add(D1_dim);
    fr13_dimlist.add(D3_dim);
    ncfile.addVariable("fr13", DataType.FLOAT, fr13_dimlist);

    ArrayList cr21_dimlist = new ArrayList();
    cr21_dimlist.add(Dr_dim);
    cr21_dimlist.add(D2_dim);
    cr21_dimlist.add(D1_dim);
    ncfile.addVariable("cr21", DataType.CHAR, cr21_dimlist);

    ArrayList br22_dimlist = new ArrayList();
    br22_dimlist.add(Dr_dim);
    br22_dimlist.add(D2_dim);
    br22_dimlist.add(D2_dim);
    ncfile.addVariable("br22", DataType.BYTE, br22_dimlist);

    ArrayList sr23_dimlist = new ArrayList();
    sr23_dimlist.add(Dr_dim);
    sr23_dimlist.add(D2_dim);
    sr23_dimlist.add(D3_dim);
    ncfile.addVariable("sr23", DataType.SHORT, sr23_dimlist);

    ArrayList fr31_dimlist = new ArrayList();
    fr31_dimlist.add(Dr_dim);
    fr31_dimlist.add(D3_dim);
    fr31_dimlist.add(D1_dim);
    ncfile.addVariable("fr31", DataType.FLOAT, fr31_dimlist);

    ArrayList dr32_dimlist = new ArrayList();
    dr32_dimlist.add(Dr_dim);
    dr32_dimlist.add(D3_dim);
    dr32_dimlist.add(D2_dim);
    ncfile.addVariable("dr32", DataType.DOUBLE, dr32_dimlist);

    ArrayList cr33_dimlist = new ArrayList();
    cr33_dimlist.add(Dr_dim);
    cr33_dimlist.add(D3_dim);
    cr33_dimlist.add(D3_dim);
    ncfile.addVariable("cr33", DataType.CHAR, cr33_dimlist);

    ArrayList c111_dimlist = new ArrayList();
    c111_dimlist.add(D1_dim);
    c111_dimlist.add(D1_dim);
    c111_dimlist.add(D1_dim);
    ncfile.addVariable("c111", DataType.CHAR, c111_dimlist);

    ArrayList b112_dimlist = new ArrayList();
    b112_dimlist.add(D1_dim);
    b112_dimlist.add(D1_dim);
    b112_dimlist.add(D2_dim);
    ncfile.addVariable("b112", DataType.BYTE, b112_dimlist);

    ArrayList s113_dimlist = new ArrayList();
    s113_dimlist.add(D1_dim);
    s113_dimlist.add(D1_dim);
    s113_dimlist.add(D3_dim);
    ncfile.addVariable("s113", DataType.SHORT, s113_dimlist);

    ArrayList f121_dimlist = new ArrayList();
    f121_dimlist.add(D1_dim);
    f121_dimlist.add(D2_dim);
    f121_dimlist.add(D1_dim);
    ncfile.addVariable("f121", DataType.FLOAT, f121_dimlist);

    ArrayList d122_dimlist = new ArrayList();
    d122_dimlist.add(D1_dim);
    d122_dimlist.add(D2_dim);
    d122_dimlist.add(D2_dim);
    ncfile.addVariable("d122", DataType.DOUBLE, d122_dimlist);

    ArrayList c123_dimlist = new ArrayList();
    c123_dimlist.add(D1_dim);
    c123_dimlist.add(D2_dim);
    c123_dimlist.add(D3_dim);
    ncfile.addVariable("c123", DataType.CHAR, c123_dimlist);

    ArrayList s131_dimlist = new ArrayList();
    s131_dimlist.add(D1_dim);
    s131_dimlist.add(D3_dim);
    s131_dimlist.add(D1_dim);
    ncfile.addVariable("s131", DataType.SHORT, s131_dimlist);

    ArrayList i132_dimlist = new ArrayList();
    i132_dimlist.add(D1_dim);
    i132_dimlist.add(D3_dim);
    i132_dimlist.add(D2_dim);
    ncfile.addVariable("i132", DataType.INT, i132_dimlist);

    ArrayList f133_dimlist = new ArrayList();
    f133_dimlist.add(D1_dim);
    f133_dimlist.add(D3_dim);
    f133_dimlist.add(D3_dim);
    ncfile.addVariable("f133", DataType.FLOAT, f133_dimlist);

    ArrayList f211_dimlist = new ArrayList();
    f211_dimlist.add(D2_dim);
    f211_dimlist.add(D1_dim);
    f211_dimlist.add(D1_dim);
    ncfile.addVariable("f211", DataType.FLOAT, f211_dimlist);

    ArrayList d212_dimlist = new ArrayList();
    d212_dimlist.add(D2_dim);
    d212_dimlist.add(D1_dim);
    d212_dimlist.add(D2_dim);
    ncfile.addVariable("d212", DataType.DOUBLE, d212_dimlist);

    ArrayList c213_dimlist = new ArrayList();
    c213_dimlist.add(D2_dim);
    c213_dimlist.add(D1_dim);
    c213_dimlist.add(D3_dim);
    ncfile.addVariable("c213", DataType.CHAR, c213_dimlist);

    ArrayList s221_dimlist = new ArrayList();
    s221_dimlist.add(D2_dim);
    s221_dimlist.add(D2_dim);
    s221_dimlist.add(D1_dim);
    ncfile.addVariable("s221", DataType.SHORT, s221_dimlist);

    ArrayList i222_dimlist = new ArrayList();
    i222_dimlist.add(D2_dim);
    i222_dimlist.add(D2_dim);
    i222_dimlist.add(D2_dim);
    ncfile.addVariable("i222", DataType.INT, i222_dimlist);

    ArrayList f223_dimlist = new ArrayList();
    f223_dimlist.add(D2_dim);
    f223_dimlist.add(D2_dim);
    f223_dimlist.add(D3_dim);
    ncfile.addVariable("f223", DataType.FLOAT, f223_dimlist);

    ArrayList c231_dimlist = new ArrayList();
    c231_dimlist.add(D2_dim);
    c231_dimlist.add(D3_dim);
    c231_dimlist.add(D1_dim);
    ncfile.addVariable("c231", DataType.CHAR, c231_dimlist);

    ArrayList b232_dimlist = new ArrayList();
    b232_dimlist.add(D2_dim);
    b232_dimlist.add(D3_dim);
    b232_dimlist.add(D2_dim);
    ncfile.addVariable("b232", DataType.BYTE, b232_dimlist);

    ArrayList s233_dimlist = new ArrayList();
    s233_dimlist.add(D2_dim);
    s233_dimlist.add(D3_dim);
    s233_dimlist.add(D3_dim);
    ncfile.addVariable("s233", DataType.SHORT, s233_dimlist);

    ArrayList s311_dimlist = new ArrayList();
    s311_dimlist.add(D3_dim);
    s311_dimlist.add(D1_dim);
    s311_dimlist.add(D1_dim);
    ncfile.addVariable("s311", DataType.SHORT, s311_dimlist);

    ArrayList i312_dimlist = new ArrayList();
    i312_dimlist.add(D3_dim);
    i312_dimlist.add(D1_dim);
    i312_dimlist.add(D2_dim);
    ncfile.addVariable("i312", DataType.INT, i312_dimlist);

    ArrayList f313_dimlist = new ArrayList();
    f313_dimlist.add(D3_dim);
    f313_dimlist.add(D1_dim);
    f313_dimlist.add(D3_dim);
    ncfile.addVariable("f313", DataType.FLOAT, f313_dimlist);

    ArrayList var_MINUS_name_MINUS_dashes_dimlist = new ArrayList();
    ncfile.addVariable("var-name-dashes", DataType.DOUBLE, var_MINUS_name_MINUS_dashes_dimlist);

    ArrayList var_PERIOD_name_PERIOD_dots_dimlist = new ArrayList();
    ncfile.addVariable("var.name.dots", DataType.DOUBLE, var_PERIOD_name_PERIOD_dots_dimlist);

    ArrayList var_PLUS_name_PLUS_plusses_dimlist = new ArrayList();
    ncfile.addVariable("var+name+plusses", DataType.DOUBLE, var_PLUS_name_PLUS_plusses_dimlist);

    ArrayList var_ATSIGN_name_ATSIGN_ats_dimlist = new ArrayList();
    ncfile.addVariable("var@name@ats", DataType.DOUBLE, var_ATSIGN_name_ATSIGN_ats_dimlist);

    /* assign global attributes */
    /* attribute: Gc */
    ncfile.addGlobalAttribute("Gc","");
    /* attribute: Gb */
    {
    Array data = Array.factory(byte.class, new int[]{2}, new byte[]{-128, 127});
    ncfile.addGlobalAttribute("Gb",data);
    }
    /* attribute: Gs */
    {
    Array data = Array.factory(short.class, new int[]{3}, new short[]{-32768, 0, 32767});
    ncfile.addGlobalAttribute("Gs",data);
    }
    /* attribute: Gi */
    {
    Array data = Array.factory(int.class, new int[]{3}, new int[]{-2147483647, 0, 2147483647});
    ncfile.addGlobalAttribute("Gi",data);
    }
    /* attribute: Gf */
    {
    Array data = Array.factory(float.class, new int[]{3}, new float[]{((float)-9.9999996e+35), ((float)0), ((float)9.9999996e+35)});
    ncfile.addGlobalAttribute("Gf",data);
    }
    /* attribute: Gd */
    {
    Array data = Array.factory(double.class, new int[]{3}, new double[]{((double)-1e+308), ((double)0), ((double)1e+308)});
    ncfile.addGlobalAttribute("Gd",data);
    }
    /* attribute: Gatt-name-dashes */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{-1});
    ncfile.addGlobalAttribute("Gatt-name-dashes",data);
    }
    /* attribute: Gatt.name.dots */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{-2});
    ncfile.addGlobalAttribute("Gatt.name.dots",data);
    }
    /* attribute: Gatt+name+plusses */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{-3});
    ncfile.addGlobalAttribute("Gatt+name+plusses",data);
    }
    /* attribute: Gatt@name@ats */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{-4});
    ncfile.addGlobalAttribute("Gatt@name@ats",data);
    }


    /* assign per-variable attributes */
    /* attribute: att-name-dashes */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{4});
    ncfile.addVariableAttribute("c","att-name-dashes",data);
    }
    /* attribute: att.name.dots */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{5});
    ncfile.addVariableAttribute("c","att.name.dots",data);
    }
    /* attribute: att+name+plusses */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{6});
    ncfile.addVariableAttribute("c","att+name+plusses",data);
    }
    /* attribute: att@name@ats */
    {
    Array data = Array.factory(int.class, new int[]{1}, new int[]{7});
    ncfile.addVariableAttribute("c","att@name@ats",data);
    }
    /* attribute: c */
    ncfile.addVariableAttribute("b","c","");
    /* attribute: b */
    {
    Array data = Array.factory(byte.class, new int[]{4}, new byte[]{0, 127, -128, -1});
    ncfile.addVariableAttribute("s","b",data);
    }
    /* attribute: s */
    {
    Array data = Array.factory(short.class, new int[]{3}, new short[]{-32768, 0, 32767});
    ncfile.addVariableAttribute("s","s",data);
    }
    /* attribute: i */
    {
    Array data = Array.factory(int.class, new int[]{3}, new int[]{-2147483647, 0, 2147483647});
    ncfile.addVariableAttribute("i","i",data);
    }
    /* attribute: f */
    {
    Array data = Array.factory(float.class, new int[]{3}, new float[]{((float)-9.9999996e+35), ((float)0), ((float)9.9999996e+35)});
    ncfile.addVariableAttribute("i","f",data);
    }
    /* attribute: d */
    {
    Array data = Array.factory(double.class, new int[]{3}, new double[]{((double)-1e+308), ((double)0), ((double)1e+308)});
    ncfile.addVariableAttribute("i","d",data);
    }
    /* attribute: c */
    ncfile.addVariableAttribute("f","c","x");
    /* attribute: c */
    ncfile.addVariableAttribute("d","c","abcd\tZ$&");

    ncfile.create();

    /* assign variable data */

    {
    ArrayChar.D0 data = new ArrayChar.D0();
    data.set((char)'2');
    ncfile.write("c",data);
    }

    {
    ArrayByte.D0 data = new ArrayByte.D0();
    data.set((byte)-2);
    ncfile.write("b",data);
    }

    {
    ArrayShort.D0 data = new ArrayShort.D0();
    data.set((short)-5);
    ncfile.write("s",data);
    }

    {
    ArrayInt.D0 data = new ArrayInt.D0();
    data.set((int)-20);
    ncfile.write("i",data);
    }

    {
    ArrayFloat.D0 data = new ArrayFloat.D0();
    data.set((float)((float)-9));
    ncfile.write("f",data);
    }

    {
    ArrayDouble.D0 data = new ArrayDouble.D0();
    data.set((double)((double)-10));
    ncfile.write("d",data);
    }

    {
    String contents = "ab";
    ArrayChar data = new ArrayChar(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0};
    ncfile.write("cr",origin,data);
    }

    {
    byte[] contents = new byte[] {-128, 127};
    ArrayByte data = new ArrayByte(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("br",origin,data);
    }

    {
    short[] contents = new short[] {-32768, 32767};
    ArrayShort data = new ArrayShort(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("sr",origin,data);
    }

    {
    int[] contents = new int[] {-2147483646, 2147483647};
    ArrayInt data = new ArrayInt(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("ir",origin,data);
    }

    {
    float[] contents = new float[] {((float)-9.9999996e+35), ((float)9.9999996e+35)};
    ArrayFloat data = new ArrayFloat(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("fr",origin,data);
    }

    {
    double[] contents = new double[] {((double)-1e+308), ((double)1e+308)};
    ArrayDouble data = new ArrayDouble(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("dr",origin,data);
    }

    {
    String contents = "";
    ArrayChar data = new ArrayChar(new int[]{1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0};
    ncfile.write("c1",origin,data);
    }

    {
    byte[] contents = new byte[] {-128};
    ArrayByte data = new ArrayByte(new int[]{1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("b1",origin,data);
    }

    {
    short[] contents = new short[] {-32768};
    ArrayShort data = new ArrayShort(new int[]{1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("s1",origin,data);
    }

    {
    int[] contents = new int[] {-2147483646};
    ArrayInt data = new ArrayInt(new int[]{1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("i1",origin,data);
    }

    {
    float[] contents = new float[] {((float)-9.9999996e+35)};
    ArrayFloat data = new ArrayFloat(new int[]{1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("f1",origin,data);
    }

    {
    double[] contents = new double[] {((double)-1e+308)};
    ArrayDouble data = new ArrayDouble(new int[]{1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("d1",origin,data);
    }

    {
    String contents = "ab";
    ArrayChar data = new ArrayChar(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0};
    ncfile.write("c2",origin,data);
    }

    {
    byte[] contents = new byte[] {-128, 127};
    ArrayByte data = new ArrayByte(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("b2",origin,data);
    }

    {
    short[] contents = new short[] {-32768, 32767};
    ArrayShort data = new ArrayShort(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("s2",origin,data);
    }

    {
    int[] contents = new int[] {-2147483646, 2147483647};
    ArrayInt data = new ArrayInt(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("i2",origin,data);
    }

    {
    float[] contents = new float[] {((float)-9.9999996e+35), ((float)9.9999996e+35)};
    ArrayFloat data = new ArrayFloat(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("f2",origin,data);
    }

    {
    double[] contents = new double[] {((double)-1e+308), ((double)1e+308)};
    ArrayDouble data = new ArrayDouble(new int[]{2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("d2",origin,data);
    }

    {
    String contents = "\u0001\u007F.";
    ArrayChar data = new ArrayChar(new int[]{3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0};
    ncfile.write("c3",origin,data);
    }

    {
    byte[] contents = new byte[] {-128, 127, -1};
    ArrayByte data = new ArrayByte(new int[]{3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("b3",origin,data);
    }

    {
    short[] contents = new short[] {-32768, 0, 32767};
    ArrayShort data = new ArrayShort(new int[]{3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("s3",origin,data);
    }

    {
    int[] contents = new int[] {-2147483646, 0, 2147483647};
    ArrayInt data = new ArrayInt(new int[]{3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("i3",origin,data);
    }

    {
    float[] contents = new float[] {((float)-9.9999996e+35), ((float)0), ((float)9.9999996e+35)};
    ArrayFloat data = new ArrayFloat(new int[]{3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("f3",origin,data);
    }

    {
    double[] contents = new double[] {((double)-1e+308), ((double)0), ((double)1e+308)};
    ArrayDouble data = new ArrayDouble(new int[]{3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0};
    ncfile.write("d3",origin,data);
    }

    {
    String contents = "xy";
    ArrayChar data = new ArrayChar(new int[]{2, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0};
    ncfile.write("cr1",origin,data);
    }

    {
    byte[] contents = new byte[] {-24, -26, -20, -22};
    ArrayByte data = new ArrayByte(new int[]{2, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("br2",origin,data);
    }

    {
    short[] contents = new short[] {-375, -380, -385, -350, -355, -360};
    ArrayShort data = new ArrayShort(new int[]{2, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("sr3",origin,data);
    }

    {
    float[] contents = new float[] {((float)-2187)};
    ArrayFloat data = new ArrayFloat(new int[]{1, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("f11",origin,data);
    }

    {
    double[] contents = new double[] {((double)-3000), ((double)-3010)};
    ArrayDouble data = new ArrayDouble(new int[]{1, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("d12",origin,data);
    }

    {
    String contents = "\tb\u007F";
    ArrayChar data = new ArrayChar(new int[]{1, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0};
    ncfile.write("c13",origin,data);
    }

    {
    short[] contents = new short[] {-375, -350};
    ArrayShort data = new ArrayShort(new int[]{2, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("s21",origin,data);
    }

    {
    int[] contents = new int[] {-24000, -24020, -23600, -23620};
    ArrayInt data = new ArrayInt(new int[]{2, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("i22",origin,data);
    }

    {
    float[] contents = new float[] {((float)-2187), ((float)-2196), ((float)-2205), ((float)-2106), ((float)-2115), ((float)-2124)};
    ArrayFloat data = new ArrayFloat(new int[]{2, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("f23",origin,data);
    }

    {
    String contents = "+- ";
    ArrayChar data = new ArrayChar(new int[]{3, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0};
    ncfile.write("c31",origin,data);
    }

    {
    byte[] contents = new byte[] {-24, -26, -20, -22, -16, -18};
    ArrayByte data = new ArrayByte(new int[]{3, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("b32",origin,data);
    }

    {
    short[] contents = new short[] {-375, -380, -385, -350, -355, -360, -325, -330, -335};
    ArrayShort data = new ArrayShort(new int[]{3, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0};
    ncfile.write("s33",origin,data);
    }

    {
    short[] contents = new short[] {2500, 2375};
    ArrayShort data = new ArrayShort(new int[]{2, 1, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("sr11",origin,data);
    }

    {
    int[] contents = new int[] {640000, 639980, 632000, 631980};
    ArrayInt data = new ArrayInt(new int[]{2, 1, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("ir12",origin,data);
    }

    {
    float[] contents = new float[] {((float)26244), ((float)26235), ((float)26226), ((float)25515), ((float)25506), ((float)25497)};
    ArrayFloat data = new ArrayFloat(new int[]{2, 1, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("fr13",origin,data);
    }

    {
    String contents = "@DHL";
    ArrayChar data = new ArrayChar(new int[]{2, 2, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("cr21",origin,data);
    }

    {
    byte[] contents = new byte[] {64, 62, 68, 66, 56, 54, 60, 58};
    ArrayByte data = new ArrayByte(new int[]{2, 2, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("br22",origin,data);
    }

    {
    short[] contents = new short[] {2500, 2495, 2490, 2525, 2520, 2515, 2375, 2370, 2365, 2400, 2395, 2390};
    ArrayShort data = new ArrayShort(new int[]{2, 2, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("sr23",origin,data);
    }

    {
    float[] contents = new float[] {((float)26244), ((float)26325), ((float)26406), ((float)25515), ((float)25596), ((float)25677)};
    ArrayFloat data = new ArrayFloat(new int[]{2, 3, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("fr31",origin,data);
    }

    {
    double[] contents = new double[] {((double)40000), ((double)39990), ((double)40100), ((double)40090), ((double)40200), ((double)40190), ((double)39000), ((double)38990), ((double)39100), ((double)39090), ((double)39200), ((double)39190)};
    ArrayDouble data = new ArrayDouble(new int[]{2, 3, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("dr32",origin,data);
    }

    {
    String contents = "1";
    ArrayChar data = new ArrayChar(new int[]{2, 3, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("cr33",origin,data);
    }

    {
    String contents = "@";
    ArrayChar data = new ArrayChar(new int[]{1, 1, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("c111",origin,data);
    }

    {
    byte[] contents = new byte[] {64, 62};
    ArrayByte data = new ArrayByte(new int[]{1, 1, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("b112",origin,data);
    }

    {
    short[] contents = new short[] {2500, 2495, 2490};
    ArrayShort data = new ArrayShort(new int[]{1, 1, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("s113",origin,data);
    }

    {
    float[] contents = new float[] {((float)26244), ((float)26325)};
    ArrayFloat data = new ArrayFloat(new int[]{1, 2, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("f121",origin,data);
    }

    {
    double[] contents = new double[] {((double)40000), ((double)39990), ((double)40100), ((double)40090)};
    ArrayDouble data = new ArrayDouble(new int[]{1, 2, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("d122",origin,data);
    }

    {
    String contents = "one2";
    ArrayChar data = new ArrayChar(new int[]{1, 2, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("c123",origin,data);
    }

    {
    short[] contents = new short[] {2500, 2525, 2550};
    ArrayShort data = new ArrayShort(new int[]{1, 3, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("s131",origin,data);
    }

    {
    int[] contents = new int[] {640000, 639980, 640400, 640380, 640800, 640780};
    ArrayInt data = new ArrayInt(new int[]{1, 3, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("i132",origin,data);
    }

    {
    float[] contents = new float[] {((float)26244), ((float)26235), ((float)26226), ((float)26325), ((float)26316), ((float)26307), ((float)26406), ((float)26397), ((float)26388)};
    ArrayFloat data = new ArrayFloat(new int[]{1, 3, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("f133",origin,data);
    }

    {
    float[] contents = new float[] {((float)26244), ((float)25515)};
    ArrayFloat data = new ArrayFloat(new int[]{2, 1, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("f211",origin,data);
    }

    {
    double[] contents = new double[] {((double)40000), ((double)39990), ((double)39000), ((double)38990)};
    ArrayDouble data = new ArrayDouble(new int[]{2, 1, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setDoubleNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("d212",origin,data);
    }

    {
    String contents = "";
    ArrayChar data = new ArrayChar(new int[]{2, 1, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("c213",origin,data);
    }

    {
    short[] contents = new short[] {2500, 2525, 2375, 2400};
    ArrayShort data = new ArrayShort(new int[]{2, 2, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("s221",origin,data);
    }

    {
    int[] contents = new int[] {640000, 639980, 640400, 640380, 632000, 631980, 632400, 632380};
    ArrayInt data = new ArrayInt(new int[]{2, 2, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("i222",origin,data);
    }

    {
    float[] contents = new float[] {((float)26244), ((float)26235), ((float)26226), ((float)26325), ((float)26316), ((float)26307), ((float)25515), ((float)25506), ((float)25497), ((float)25596), ((float)25587), ((float)25578)};
    ArrayFloat data = new ArrayFloat(new int[]{2, 2, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("f223",origin,data);
    }

    {
    String contents = "@DHHLP";
    ArrayChar data = new ArrayChar(new int[]{2, 3, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setCharNext(contents.charAt(count++));
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("c231",origin,data);
    }

    {
    byte[] contents = new byte[] {64, 62, 68, 66, 72, 70, 56, 54, 60, 58, 64, 62};
    ArrayByte data = new ArrayByte(new int[]{2, 3, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setByteNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("b232",origin,data);
    }

    {
    short[] contents = new short[] {2500, 2495, 2490, 2525, 2520, 2515, 2550, 2545, 2540, 2375, 2370, 2365, 2400, 2395, 2390, 2425, 2420, 2415};
    ArrayShort data = new ArrayShort(new int[]{2, 3, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("s233",origin,data);
    }

    {
    short[] contents = new short[] {2500, 2375, 2250};
    ArrayShort data = new ArrayShort(new int[]{3, 1, 1});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setShortNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("s311",origin,data);
    }

    {
    int[] contents = new int[] {640000, 639980, 632000, 631980, 624000, 623980};
    ArrayInt data = new ArrayInt(new int[]{3, 1, 2});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setIntNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("i312",origin,data);
    }

    {
    float[] contents = new float[] {((float)26244), ((float)26235), ((float)26226), ((float)25515), ((float)25506), ((float)25497), ((float)24786), ((float)24777), ((float)24768)};
    ArrayFloat data = new ArrayFloat(new int[]{3, 1, 3});
    IndexIterator iter = data.getIndexIterator();
    int count = 0;
    while(iter.hasNext())
        iter.setFloatNext(contents[count++]);
    int[] origin = new int[]{0, 0, 0};
    ncfile.write("f313",origin,data);
    }

    {
    ArrayDouble.D0 data = new ArrayDouble.D0();
    data.set((double)((double)-1));
    ncfile.write("var-name-dashes",data);
    }

    {
    ArrayDouble.D0 data = new ArrayDouble.D0();
    data.set((double)((double)-2));
    ncfile.write("var.name.dots",data);
    }

    {
    ArrayDouble.D0 data = new ArrayDouble.D0();
    data.set((double)((double)9.969209968386869e+36));
    ncfile.write("var+name+plusses",data);
    }

    {
    ArrayDouble.D0 data = new ArrayDouble.D0();
    data.set((double)((double)9.969209968386869e+36));
    ncfile.write("var@name@ats",data);
    }

    ncfile.close();

    }
}
