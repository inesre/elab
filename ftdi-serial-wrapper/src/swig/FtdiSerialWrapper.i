%module FtdiSerialWrapper
%{
#include "windows.h"
#include "FTD2XX.h"

typedef struct {
	FT_HANDLE handle;
	FT_STATUS status;
} FTClassicPort;
%}

#define FTD2XX_API 
#define WINAPI

typedef void *	FT_HANDLE;
typedef unsigned long FT_STATUS;

typedef bool BOOL;
typedef unsigned char UCHAR,*PUCHAR;
typedef unsigned short USHORT;
typedef unsigned short WORD;
typedef unsigned long ULONG,*PULONG;
typedef void *PVOID,*LPVOID;
typedef char CHAR;
typedef unsigned char BYTE;
typedef unsigned long DWORD;
typedef WORD *PWORD,*LPWORD;
typedef CHAR *PCHAR,*LPCH,*PCH,*NPSTR,*LPSTR,*PSTR;
typedef DWORD *PDWORD,*LPDWORD;
typedef const CHAR *LPCCH,*PCSTR,*LPCSTR;

%include "arrays_java.i"
%apply signed char [] {LPVOID lpBuffer};

typedef struct {
	FT_HANDLE handle;
	FT_STATUS status;
} FTClassicPort;


%extend FTClassicPort {
%javaexception ("java.io.IOException" ) {
	$action
	if(arg1->status != FT_OK){
		jclass clazz = (*jenv)->FindClass(jenv, "java/io/IOException");
		(*jenv)->ThrowNew(jenv, clazz, "IOException");
		return $null;
	}
}

void open(int deviceNumber)
{
	self->status = FT_Open(deviceNumber, &(self->handle));
}

void close()
{
	self->status =  FT_Close(self->handle);
}

DWORD read(LPVOID lpBuffer,
    DWORD nBufferSize
    )
{
	DWORD output;
	self->status = FT_Read(self->handle, lpBuffer, nBufferSize,
		&output);
	return output;		
}

DWORD write(LPVOID lpBuffer,
    DWORD nBufferSize)
{
	DWORD output;
	self->status = FT_Write(self->handle, lpBuffer, nBufferSize,
		&output);
	return output;
}

void setBaudRate(ULONG BaudRate)
{
	self->status = FT_SetBaudRate(self->handle, BaudRate);
}
void setDataCharacteristics(
	UCHAR WordLength,
	UCHAR StopBits,
	UCHAR Parity
	)
{
	self->status = FT_SetDataCharacteristics(self->handle, WordLength,
		StopBits, Parity);
}

void setFlowControl(
    USHORT FlowControl,
    UCHAR XonChar,
    UCHAR XoffChar
	)
{
	self->status = FT_SetFlowControl(self->handle, FlowControl,
		XonChar, XoffChar);
}
	
void resetDevice()
{
	self->status = FT_ResetDevice(self->handle);
}

void setDtr()
{
    self->status = FT_SetDtr(self->handle);
}

void clrDtr()
{
	self->status = FT_ClrDtr(self->handle);
}

void setRts()
{
	self->status = FT_SetRts(self->handle);
}

void crRts()
{
	self->status = FT_ClrRts(self->handle);
}

void setTimeouts(
	ULONG ReadTimeout,
	ULONG WriteTimeout
	)
{
	self->status = FT_SetTimeouts(self->handle,
		ReadTimeout, WriteTimeout);		
}

void resetPort()
{
	self->status = FT_ResetPort(self->handle);
}

};
